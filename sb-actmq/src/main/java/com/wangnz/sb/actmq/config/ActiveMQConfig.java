package com.wangnz.sb.actmq.config;


import com.wangnz.sb.actmq.constant.ActiveMQQueueConst;
import com.wangnz.sb.actmq.constant.ActiveMQTopicConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * @author WANGNANZHI
 * @description ActiveMQ消息队列配置类
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
@Configuration
public class ActiveMQConfig {
    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean(ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean(ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
