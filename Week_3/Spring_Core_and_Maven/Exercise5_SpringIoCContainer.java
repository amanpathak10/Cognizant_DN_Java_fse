import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise5_SpringIoCContainer {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Spring IoC Container Initialized");
        System.out.println("Total beans: " + context.getBeanDefinitionCount());
        
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Design Patterns", "Gang of Four");
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

class BookRepository {
    private java.util.List<Book> books = new java.util.ArrayList<>();
    
    public void save(Book book) {
        books.add(book);
        System.out.println("Repository: Saved book - " + book.getTitle());
    }
    
    public java.util.List<Book> findAll() {
        return new java.util.ArrayList<>(books);
    }
}

class BookService {
    private BookRepository bookRepository;
    private String applicationName = "Library Management System";
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        bookRepository.save(book);
    }
    
    public void listBooks() {
        System.out.println("\n" + applicationName);
        System.out.println("Books in Database:");
        for (Book book : bookRepository.findAll()) {
            System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
