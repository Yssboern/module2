package learn.epam.module2;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
//import javax.ws.rs.core.UriBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KAP {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092"); // Corrected the property name.
        properties.setProperty("acks", "1");
        properties.setProperty("retries", "10");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081"); // Corrected the URL.

        KafkaProducer<String, AvroUser> kafkaProducer = new KafkaProducer<>(properties);

//        UriBuilder b=new UriBuilder();

        String topic = "blep";
        AvroUser avroUser = new AvroUser();
        avroUser.setName("Tgn");
        avroUser.setFavoriteColor("Dark Green");
        avroUser.setFavoriteNumber(666);

        ProducerRecord<String, AvroUser> producerRecord = new ProducerRecord<>(topic, avroUser);
        kafkaProducer.send(producerRecord); // Send the data.
        kafkaProducer.close(); // Close the producer when done.
    }
}
