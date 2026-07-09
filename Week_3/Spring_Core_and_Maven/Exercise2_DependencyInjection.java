import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise2_DependencyInjection {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Effective Java", "Joshua Bloch");
        bookService.addBook("Clean Code", "Robert Martin");
        bookService.displayBooks();
        
        System.out.println("\nTotal Books: " + bookService.getTotalBooks());
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

class BookRepository {
    private java.util.List<Book> books = new java.util.ArrayList<>();
    
    public void save(Book book) {
        books.add(book);
        System.out.println("Repository: Book saved - " + book.getTitle());
    }
    
    public java.util.List<Book> findAll() {
        return books;
    }
    
    public int count() {
        return books.size();
    }
}

class BookService {
    private BookRepository bookRepository;
    
    public BookService() {}
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookRepository.save(book);
    }
    
    public void displayBooks() {
        System.out.println("Books in Library:");
        for (Book book : bookRepository.findAll()) {
            System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
        }
    }
    
    public int getTotalBooks() {
        return bookRepository.count();
    }
}
