package springboot.kafka.webservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import springboot.kafka.webservice.payload.Book;
import springboot.kafka.webservice.repository.BookRepository;

/**
 * JsonKafkaConsumerDb
 * This class is used to consume the data from the kafka topic and send it to the database
 * Annotation Service is used to mark the class as a service provider
 * Annotation Autowired is used to inject the object dependency
 * Annotation KafkaListener is used to listen to the kafka topic
 */
@Service
public class JsonKafkaConsumerDb {
    @Autowired
    private BookRepository bookRepository;
    @KafkaListener(topics = "bookTopic_json",groupId = "otherGroup")

    public void writeToDb(Book book){
        System.out.println("Skickar data till DB");
        //Skicka data till databasen
        bookRepository.save(book);
    }

}
