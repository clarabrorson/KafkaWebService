package springboot.kafka.webservice;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.kafka.webservice.payload.Book;
import springboot.kafka.webservice.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DatabaseTests
 * This class is used to test the database operations
 * It uses BookRepository to perform the database operations
 * The test cases are executed in the order specified by the @Order annotation
 * The test cases are executed together in a single transaction, by running the class.
 * testBook is used to store the book object created in the first test case
 * and is used in the following test cases.
 * The tests does not effect the database.
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTests {

    @Autowired
    BookRepository bookRepository;
    static Book testBook;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Running all tests");
    }
    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests completed");
    }

    @Test
    @Order(1)
    void createBook() {
        Book book = new Book();
        book.setAuthor("A");
        book.setTitle("B");
        book.setGenre("C");
        testBook = bookRepository.save(book);

        assertNotNull(bookRepository.findById(testBook.getId()).get().getAuthor());
    }

    @Test
    @Order(2)
    void updateBook() {
        //Hämta bok med id 1
        Book fetchedBook = bookRepository.findById(testBook.getId()).get();
        assertNotNull(fetchedBook);

        fetchedBook.setAuthor("D");
        bookRepository.save(fetchedBook);

        assertEquals("D", bookRepository.findById(testBook.getId()).get().getAuthor());
    }

    @Test
    @Order(3)
    void removeBook() {

        assertNotNull(bookRepository.findById(testBook.getId()).get());

        bookRepository.deleteById(testBook.getId());

        assertTrue(bookRepository.findById(testBook.getId()).isEmpty());

    }
}
