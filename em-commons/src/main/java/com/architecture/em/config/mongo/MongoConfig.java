package com.architecture.em.config.mongo;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.architecture.em")
public class MongoConfig {

    @Value("${mongodb.url}")
    private String url;

    @Value("${mongodb.post}")
    private Integer post;

    @Value("${mongodb.dbName}")
    private String dbName;

    @Value(("${mongodb.user}"))
    private String user;

    @Value(("${mongodb.password}"))
    private String password;

    @Autowired
    private Mongo mongo;


    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        //设置数据库用户名密码
     /*   MongoCredential mongoCredential = MongoCredential.createMongoCRCredential(user, dbName, password.toCharArray());*/
        mongo.setHost(url);
        mongo.setPort(post);
       /* mongo.setCredentials(new MongoCredential[]{mongoCredential});*/
        return mongo;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo, dbName);
    }
}
