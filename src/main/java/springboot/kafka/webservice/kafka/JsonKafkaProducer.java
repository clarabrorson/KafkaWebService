package springboot.kafka.webservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import springboot.kafka.webservice.payload.Book;

/**
 * JsonKafkaProducer
 * This class is used to send the message to the kafka topic
 * Annotation @Service is used to mark the class as a service provider
 * KafkaTemplate is used to send the message to the kafka topic by using the send() method
 */
@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Book> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Book> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Book data){

        LOGGER.info(String.format("Json Message sent -> %s",data.toString()));
        Message<Book> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"bookTopic_json")
                .build();

        kafkaTemplate.send(message);

    }
}
