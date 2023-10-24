package learn.epam.module2;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//@Service
public class KafkaAvroConsumerService {

    @KafkaListener(topics = "blep")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }

    @KafkaListener(topics = "your-topic")
    public void consumeMessageWithSchema(@Payload byte[] message,
                                         @Header("schemaId") int schemaId) {

        // Use the schema ID to look up the corresponding Avro schema
//        Schema schema = schemaRegistry.getSchemaById(schemaId);
//
//        // Deserialize the message using the correct schema
//        GenericRecord data = avroDeserializer.deserialize(message, schema);

        // Process the data
        // ...
    }

}
