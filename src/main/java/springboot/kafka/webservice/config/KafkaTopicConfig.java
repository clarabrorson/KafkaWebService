package springboot.kafka.webservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * KafkaTopicConfig
 * This class is used to create topics in Kafka
 * Annotation Configuration is used to create beans
 * Annotation Bean is used to create a new topic
 */

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic bookTopic(){
        return TopicBuilder.name("bookTopic")
                .build();
    }
    @Bean
    public NewTopic bookJsonTopic(){
        return TopicBuilder.name("bookTopic_json")
                .build();
    }
}
