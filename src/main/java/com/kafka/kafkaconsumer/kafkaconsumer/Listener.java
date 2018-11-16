package com.kafka.kafkaconsumer.kafkaconsumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author devagoud
 */
@Component
public class Listener {

  //  @Autowired
  //  KafkaConsumer kafkaConsumer;

    @KafkaListener(topics = "deva",groupId = "my-group-id")
    public void listen(@Payload String message) {
       // kafkaConsumer.commitSync();
        System.out.println("Received Messasge in group foo: " + message);
    }
}
