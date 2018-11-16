package com.kafka.kafkaconsumer.kafkaconsumer;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author devagoud
 */
@Getter
@Setter
public class Greeting {
String id= UUID.randomUUID().toString();
String msg;


}
