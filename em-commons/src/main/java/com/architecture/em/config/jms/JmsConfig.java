package com.architecture.em.config.jms;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
@EnableJms
public class JmsConfig {

    @Value("${activemq.brokerUrl}")
    private String brokerUrl;

    @Value("${activemq.defaultTopicName}")
    private String topicName;

    @Value("${activemq.timeToLive}")
    private Integer timeToLive;

    @Value("${activemq.sessionCacheSize}")
    private Integer sessionCacheSize;


    @Autowired
    private ActiveMQConnectionFactory activeMQConnectionFactory;

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    private ActiveMQTopic activeMQTopic;

    @Autowired
    private MappingJackson2MessageConverter mappingJackson2MessageConverter;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        return new ActiveMQConnectionFactory(brokerUrl);
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(activeMQConnectionFactory);
        cachingConnectionFactory.setSessionCacheSize(sessionCacheSize);
        return cachingConnectionFactory;
    }

    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic(topicName);
    }

    @Bean
    public DefaultJmsListenerContainerFactory topicListenerContainerFactory() {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(cachingConnectionFactory);
        jmsListenerContainerFactory.setPubSubDomain(true);
        jmsListenerContainerFactory.setSessionTransacted(true);
        return jmsListenerContainerFactory;
    }


    @Bean
    public JmsMessagingTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setDeliveryPersistent(true);
        template.setExplicitQosEnabled(true);
        template.setTimeToLive(timeToLive);
        JmsMessagingTemplate jmsTemplate = new JmsMessagingTemplate(template);
        jmsTemplate.setConnectionFactory(cachingConnectionFactory());
        jmsTemplate.setDefaultDestination(activeMQTopic);
        jmsTemplate.setMessageConverter(mappingJackson2MessageConverter);
        return jmsTemplate;
    }
}
