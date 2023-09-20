package springboot.kafka.webservice;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.kafka.webservice.payload.Book;
import springboot.kafka.webservice.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DatabaseTests {

    @Autowired
    BookRepository bookRepository;

    static Book testBook; // ta bort(om du vill återställa testerna så att de kan köra enskilt)

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

        System.out.println("After all tests");
    }

    @Test
    @Order(1)
    void createBook() {
        Book book = new Book();
        book.setAuthor("A");
        book.setTitle("B");
        book.setGenre("C");
        //Sparar bok i DB
        //bookRepository.save(book);
        testBook = bookRepository.save(book); // ta bort(om du vill återställa testerna så att de kan köra enskilt)

        //Kontrollera att boken finns i databasen
        //assertNotNull(bookRepository.findById(1L).get());
        assertNotNull(bookRepository.findById(testBook.getId()).get().getAuthor());// ta bort(om du vill återställa testerna så att de kan köra enskilt)
    }

    @Test
    @Order(2)
    void updateBook() {
        //Hämta bok med id 1
        Book fetchedBook = bookRepository.findById(testBook.getId()).get();
        assertNotNull(fetchedBook);

        fetchedBook.setAuthor("D");
        bookRepository.save(fetchedBook);
        //Kontrollera att boken har uppdaterats
        //assertNotNull(bookRepository.findById(1L).get().getAuthor());
        assertEquals("D", bookRepository.findById(testBook.getId()).get().getAuthor()); // ta bort(om du vill återställa testerna så att de kan köra enskilt
    }

    @Test
    @Order(3)
    void removeBook() {
        //assertNotNull(bookRepository.findById(1L).get());
        assertNotNull(bookRepository.findById(testBook.getId()).get()); // ta bort(om du vill återställa testerna så att de kan köra enskilt)
        bookRepository.deleteById(testBook.getId()); // ta bort(om du vill återställa testerna så att de kan köra enskilt)
        assertTrue(bookRepository.findById(testBook.getId()).isEmpty()); // ta bort(om du vill återställa testerna så att de kan köra enskilt)
    }
}
