package org.james.standaloneactivemqdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

// I missed the @Component annotation, Spring does not recognize it as Spring bean.
@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination="test-queue")
    public void messageListener(String message) {
        LOGGER.info("Message received: " + message);
    }

//    // should use "${jmg.queue}"
//    @JmsListener(destination = "test-queque")
//    public void messageListener(SystemMessage systemMessage) {
//        LOGGER.info("Message Received: {}", systemMessage);
//    }

    public void good() {;;
    }
}
