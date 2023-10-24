package learn.epam.module2;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class KafkaAvroProducerService {

    private final KafkaAvroSerializer avroSerializer;
    private final KafkaTemplate<String, ProducerRecord<String, byte[]>> kafkaTemplate;
    private final String topic = "blep";

    public KafkaAvroProducerService(KafkaAvroSerializer avroSerializer, KafkaTemplate<String, ProducerRecord<String, byte[]>> kafkaTemplate) {
        this.avroSerializer = avroSerializer;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessageWithSchema(String topic, GenericRecord data, int schemaId) {
        // Serialize data using the schema for serialization
        AvroUser user = new AvroUser();
        byte[] serializedData = avroSerializer.serialize(topic, user);

//         Include the schema ID in the message, e.g., as a message header
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(topic, serializedData);
        record.headers().add(new RecordHeader("schemaId", Integer.toString(schemaId).getBytes()));

//         Send the record to Kafka
        kafkaTemplate.send(topic, record);
    }

}
