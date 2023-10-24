package com.epam.learn.avro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.learn.User;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api")
public class Controller {

    private final AvroProducer avroProducer;
    private final KafkaSimpleProducer kafkaSimpleProducer;

    public Controller(AvroProducer avroProducer, KafkaSimpleProducer kafkaSimpleProducer) {
        this.avroProducer = avroProducer;
        this.kafkaSimpleProducer = kafkaSimpleProducer;
    }

    @PostMapping("/simple")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
        kafkaSimpleProducer.sendMessage(message);
        return "Message sent to Kafka topic!";
    }

    @PostMapping(value = "/user")
    public void sendMsg(@RequestBody User user) {
        this.avroProducer.sendMessage(user);
    }

}