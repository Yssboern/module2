package learn.epam.module2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "blep")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
