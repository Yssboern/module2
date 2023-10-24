package com.epam.learn.avro;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class AvroProperties {

    @Value("${topic.name}")
    private String topicName;

    @Value("${topic.partitions-num}")
    private Integer partitions;

    @Value("${topic.replication-factor}")
    private short replicationFactor;

    @Bean
    NewTopic createNewTopic() {
        return new NewTopic(topicName, partitions, replicationFactor);
    }
}
