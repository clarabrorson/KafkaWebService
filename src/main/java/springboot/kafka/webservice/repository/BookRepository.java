package springboot.kafka.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.kafka.webservice.payload.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
