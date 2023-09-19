package springboot.kafka.webservice.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.kafka.webservice.kafka.JsonKafkaProducer;
import springboot.kafka.webservice.payload.Book;

/**
 * JsonMessageController
 * This class is used to send json message to kafka topic
 * It uses JsonKafkaProducer class to send message to kafka topic
 * It uses User class as a payload
 * Annotation RestController is used to create RESTful web services
 * Annotation RequestMapping is used to map web requests
 * Annotation PostMapping is used to send json message to kafka topic
 */
@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Book book){
        kafkaProducer.sendMessage(book);
        return ResponseEntity.ok("Json message sent to kafka topic");

    }
}
