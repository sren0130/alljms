package org.james.artemisdemo.controller;

import org.james.artemisdemo.service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    DispatcherService dispatcherService;

    @GetMapping("/test")
    public String test() {
        return "Working....";
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody String message) {
        dispatcherService.sendMessage(message);
        return new ResponseEntity<>("Message send " + message, HttpStatus.OK);

    }
}
