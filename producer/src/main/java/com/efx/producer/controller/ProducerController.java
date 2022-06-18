package com.efx.producer.controller;

import com.efx.producer.sender.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final MessageSender<String> messageSender;

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        log.info("Message received: %s, \n About to publish to the queue...".formatted(message));
        messageSender.sendMessage(message);
    }
}
