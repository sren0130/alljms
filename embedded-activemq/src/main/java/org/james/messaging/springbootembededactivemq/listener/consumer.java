package org.james.messaging.springbootembededactivemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class consumer {

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message) {
        System.out.println("Message received: " + message);

    }
}
