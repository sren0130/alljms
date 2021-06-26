package org.james.standaloneactivemqdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Comment out annotaion means no more Spring bean, not used anymore.
 */
//@Configuration
//@EnableJms
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory =
                new DefaultJmsListenerContainerFactory();

        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setConcurrency("5-10");

        return jmsListenerContainerFactory;
    }
}
