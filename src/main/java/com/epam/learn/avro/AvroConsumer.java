package com.epam.learn.avro;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.epam.learn.User;

@Service
public class AvroConsumer {

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(ConsumerRecord<String, User> record) {
        System.out.println(String.format("Avro Consumer consumed: %s", record.value()));
    }

}