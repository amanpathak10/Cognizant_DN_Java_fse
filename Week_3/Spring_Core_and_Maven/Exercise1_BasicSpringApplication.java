import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise1_BasicSpringApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Spring in Action", "Craig Walls");
        bookService.displayBooks();
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
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
}

class BookRepository {
    private java.util.List<Book> books = new java.util.ArrayList<>();
    
    public void save(Book book) {
        books.add(book);
        System.out.println("Book saved: " + book.getTitle());
    }
    
    public java.util.List<Book> findAll() {
        return books;
    }
}

class BookService {
    private BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookRepository.save(book);
    }
    
    public void displayBooks() {
        System.out.println("All Books:");
        for (Book book : bookRepository.findAll()) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
