package com.kafka.kafkaconsumer.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author devagoud
 */
@Component
public class Listener {
    @KafkaListener(topics = "deva",groupId = "my-group-id")
    public void listen(@Payload String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }
}
