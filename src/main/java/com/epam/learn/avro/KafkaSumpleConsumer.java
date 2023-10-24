package com.epam.learn.avro;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaSumpleConsumer {

    private final String topics = "simple";

    @KafkaListener(topics = topics)
    public void consumeMessage(String message) {
        System.out.println("Simple consumer consumed: " + message);
    }
}