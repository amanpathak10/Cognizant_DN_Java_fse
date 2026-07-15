import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
public class Exercise6_AnnotationBeans {
    
    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }
    
    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Exercise6_AnnotationBeans.class);
        
        System.out.println("Annotation-Based Configuration Loaded");
        System.out.println("Total beans: " + context.getBeanDefinitionCount());
        
        BookService bookService = context.getBean(BookService.class);
        bookService.addBook("Refactoring", "Martin Fowler");
        bookService.listBooks();
    }
}

class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}

@Repository
class BookRepository {
    private java.util.List<Book> books = new java.util.ArrayList<>();
    
    public void save(Book book) {
        books.add(book);
        System.out.println("Repository: Book saved - " + book.getTitle());
    }
    
    public java.util.List<Book> findAll() {
        return new java.util.ArrayList<>(books);
    }
}

@Service
class BookService {
    private BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookRepository.save(book);
    }
    
    public void listBooks() {
        System.out.println("\nAll Books:");
        for (Book book : bookRepository.findAll()) {
            System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
