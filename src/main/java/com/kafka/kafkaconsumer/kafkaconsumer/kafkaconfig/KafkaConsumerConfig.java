package com.kafka.kafkaconsumer.kafkaconsumer.kafkaconfig;

import com.kafka.kafkaconsumer.kafkaconsumer.Greeting;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author devagoud
 */

@Configuration
public class KafkaConsumerConfig {

//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(
//                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//               "localhost:9092");
//        props.put(
//                ConsumerConfig.GROUP_ID_CONFIG,"consumer");
//        props.put(
//                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        props.put(
//                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        return new DefaultKafkaConsumerFactory(props,null,new JsonDeserializer<>(Greeting.class));
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String>
//    kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, String> factory
//                = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
    @Bean
    public KafkaConsumer kafkaConsumer(){
        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", "localhost:9092");
        consumerProps.put("group.id", "my-group-id");
        consumerProps.put("enable.auto.commit", "true");
        consumerProps.put("auto.offset.reset","latest");
        //read_committed: In addition to reading messages that are not part of a transaction, also be able to read ones that are, after the transaction is committed.
        //read_uncommitted: Read all messages in offset order without waiting for transactions to be committed. This option is similar to the current semantics of a Kafka consumer.
        consumerProps.put("isolation.level", "read_committed");
        consumerProps.put("key.deserializer", StringDeserializer.class.getName());
        consumerProps.put("value.deserializer",StringDeserializer.class.getName());
        return new KafkaConsumer(consumerProps);

    }


}

