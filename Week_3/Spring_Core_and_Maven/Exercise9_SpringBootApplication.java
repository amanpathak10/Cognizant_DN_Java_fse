import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class Exercise9_SpringBootApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Exercise9_SpringBootApplication.class, args);
        System.out.println("Spring Boot Application Started");
        System.out.println("Server running on http://localhost:8080");
    }
}

@Entity
class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    
    public Book() {}
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
}

interface BookRepository extends JpaRepository<Book, Long> {
}

@RestController
@RequestMapping("/api/books")
class BookController {
    
    private BookRepository bookRepository;
    
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @GetMapping
    public java.util.List<Book> getAllBooks() {
        System.out.println("Get all books endpoint called");
        return bookRepository.findAll();
    }
    
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        System.out.println("Create book endpoint called: " + book.getTitle());
        return bookRepository.save(book);
    }
}
