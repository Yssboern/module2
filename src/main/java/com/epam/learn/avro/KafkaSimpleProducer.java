package com.epam.learn.avro;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSimpleProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "simple";

    public KafkaSimpleProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(topic, message);
    }
}