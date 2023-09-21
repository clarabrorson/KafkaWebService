package springboot.kafka.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.kafka.webservice.payload.Book;

/**
 * BookRepository
 * This interface is used to perform database operations on the Book table
 * It extends JpaRepository which contains all the methods to perform CRUD operations on the Book table
 * JpaRepository takes two parameters, the entity class and the primary key type of the entity class
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
