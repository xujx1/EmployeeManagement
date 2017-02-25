package com.architecture.em.config;

import com.architecture.em.config.aop.AopConfig;
import com.architecture.em.config.cache.EhCacheConfig;
import com.architecture.em.config.db.DataSources;
import com.architecture.em.config.db.ThreadLocalRountingDataSource;
import com.architecture.em.config.executor.ExecutorConfig;
import com.architecture.em.config.jms.JmsConfig;
import com.architecture.em.config.mongo.MongoConfig;
import com.architecture.em.config.mybatis.MybatisConfig;
import com.architecture.em.config.mybatis.SqlSessionFactoryConfig;
import com.architecture.em.config.redis.RedisConfig;
import com.architecture.em.config.rest.RestConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableWebMvc
@ComponentScan(basePackages = "com.architecture.em")
@Import(value = {AopConfig.class, RedisConfig.class, JmsConfig.class, MongoConfig.class, EhCacheConfig.class, ExecutorConfig.class, RestConfig.class, MybatisConfig.class, SqlSessionFactoryConfig.class})
public class RootConfig {

    @Value("${jdbc.read.url}")
    private String readUrl;

    @Value("${jdbc.read.username}")
    private  String readUsername;

    @Value("${jdbc.read.password}")
    private  String readPassword;


    @Value("${jdbc.master.url}")
    private  String masterUrl;

    @Value("${jdbc.master.username}")
    private  String masterUsername;

    @Value("${jdbc.master.password}")
    private  String masterPassword;


    @Inject
    private ObjectMapper objectMapper;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        //设置Jackson 序列化方式
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //使用enableDefaultTyping()枚举指定什么样的类型（类）默认输入应该使用
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        return objectMapper;
    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setSerializedPayloadClass(String.class);
        mappingJackson2MessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2MessageConverter;
    }


    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ThreadLocalRountingDataSource threadLocalRountingDataSource() throws Exception {
        DataSource writeDb=writeDb();
        DataSource readDb=readDb();

        Map<Object ,Object> map=new ConcurrentHashMap<>();
        map.put( DataSources.READ,readDb);
        map.put( DataSources.WRITE,writeDb);

        ThreadLocalRountingDataSource threadLocalRountingDataSource = new ThreadLocalRountingDataSource();
        threadLocalRountingDataSource.setDefaultTargetDataSource(writeDb);
        threadLocalRountingDataSource.setTargetDataSources(map);
        return threadLocalRountingDataSource;
    }


    @SuppressWarnings("Duplicates")
    private DataSource writeDb() throws SQLException,PropertyVetoException {
        ComboPooledDataSource datasource = commonPart();
        datasource.setJdbcUrl(masterUrl);
        datasource.setUser(masterUsername);
        datasource.setPassword(masterPassword);
        return datasource;
    }


    @SuppressWarnings("Duplicates")
    private DataSource readDb() throws SQLException, PropertyVetoException {
        ComboPooledDataSource datasource = commonPart();
        datasource.setJdbcUrl(readUrl);
        datasource.setUser(readUsername);
        datasource.setPassword(readPassword);
        return datasource;
    }

    private ComboPooledDataSource commonPart() throws PropertyVetoException {

        ComboPooledDataSource datasource = new ComboPooledDataSource();
        datasource.setDriverClass("com.mysql.jdbc.Driver");
        datasource.setInitialPoolSize(10);
        datasource.setMinPoolSize(5);
        datasource.setMaxPoolSize(100);

        // 连接等待超时的时间,单位秒
        datasource.setMaxIdleTime(56);
        //JDBC的标准参数，用以控制数据源内加载的PreparedStatements数量
        datasource.setMaxStatements(0);

        datasource.setNumHelperThreads(3);
        // 每56秒检查所有连接池中的空闲连接
        datasource.setIdleConnectionTestPeriod(56);
        datasource.setPreferredTestQuery("select 1");

        return datasource;

    }

    private static PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }



}
