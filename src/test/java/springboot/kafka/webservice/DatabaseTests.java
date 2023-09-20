package springboot.kafka.webservice;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.kafka.webservice.payload.Book;
import springboot.kafka.webservice.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTests {

    @Autowired
    BookRepository bookRepository;
    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @Test
    @Order(1)
    void createBook() {
        Book book = new Book();
        book.setAuthor("A");
        book.setTitle("B");
        book.setGenre("C");
        //Sparar bok i DB
        bookRepository.save(book);

        //Kontrollera att boken finns i databasen
        assertNotNull(bookRepository.findById(1L).get());
    }

    @Test
    @Order(2)
    void updateBook() {
        //Hämta bok med id 1
        Book fetchedBook = bookRepository.findById(1L).get();
        assertNotNull(fetchedBook);

        fetchedBook.setAuthor("D");
        bookRepository.save(fetchedBook);
        //Kontrollera att boken har uppdaterats
        assertNotNull(bookRepository.findById(1L).get().getAuthor());
    }

    @Test
    @Order(3)
    void removeBook() {
        assertNotNull(bookRepository.findById(1L).get());
        bookRepository.deleteById(1L);
        assertTrue(bookRepository.findById(1L).isEmpty());
    }
}
