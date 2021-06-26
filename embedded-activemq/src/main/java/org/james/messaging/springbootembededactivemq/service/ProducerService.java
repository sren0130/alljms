package org.james.messaging.springbootembededactivemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerService {

    @Autowired
    private Queue queue;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") String message) {
        jmsTemplate.convertAndSend(queue, message);

        return "Published Successfully";
    }
}
