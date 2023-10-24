package com.epam.learn.avro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.epam.learn.User;

@Service
public class AvroProducer {

    @Value("${topic.name}")
    private String TOPIC;

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public AvroProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessage(User user) {
        var result = this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
        System.out.println(String.format("Avro producer send: %s", user.toString()));
    }
}
