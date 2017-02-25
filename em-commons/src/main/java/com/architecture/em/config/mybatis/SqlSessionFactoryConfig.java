package com.architecture.em.config.mybatis;

import com.architecture.em.config.db.ThreadLocalRountingDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.inject.Inject;
import java.util.Properties;

@Configuration
public class SqlSessionFactoryConfig {

    @Inject
    private ThreadLocalRountingDataSource threadLocalRountingDataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(threadLocalRountingDataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
        bean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
        bean.setPlugins(new Interceptor[]{pageHelper()});

        return bean.getObject();
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(threadLocalRountingDataSource);
    }


    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(threadLocalRountingDataSource);
    }



    private static PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

}
