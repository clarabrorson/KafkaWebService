package springboot.kafka.webservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springboot.kafka.webservice.payload.Book;

/**
 * JsonKafkaConsumer
 * This class is used to consume the json message from the kafka topic
 * It uses User class as a payload
 * Annotation Service is used to mark the class as a service provider
 * Annotation KafkaListener is used to listen to the kafka topic provided
 */
@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "bookTopic_json",groupId = "myGroup")
    public void consume(Book book){

        LOGGER.info(String.format("Json Message recieved -> %s",book.toString()));

    }
}
