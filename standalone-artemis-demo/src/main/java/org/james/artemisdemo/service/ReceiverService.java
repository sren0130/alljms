package org.james.artemisdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

// this service can be marked as @Component, same, it does not receive any directly calls, it just
// listens to the queue and process the message on the queue.

@Service
public class ReceiverService {

    Logger log = LoggerFactory.getLogger(ReceiverService.class);

    @JmsListener(destination="${jms.queue}")
    public void receiveMessage(String message) {
        log.info("Received message: " + message);   // how come? no JmsTemplate?
    }
}
