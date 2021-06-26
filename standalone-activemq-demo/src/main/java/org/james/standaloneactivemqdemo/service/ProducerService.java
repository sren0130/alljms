package org.james.standaloneactivemqdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerService {

    @Value("${jms.queue}")
    String queue;       // no true queue is required to instantiate it.

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public String send(@PathVariable("message") String message) {
        jmsTemplate.convertAndSend(queue, message);
        return "Published Successfully";
    }
}
