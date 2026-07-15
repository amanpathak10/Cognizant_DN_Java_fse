import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise7_ConstructorAndSetterInjection {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Constructor and Setter Injection Test");
        
        BookServiceConstructor bookServiceConstructor = 
            (BookServiceConstructor) context.getBean("bookServiceConstructor");
        bookServiceConstructor.addBook("Constructor Book", "Author A");
        
        BookServiceSetter bookServiceSetter = 
            (BookServiceSetter) context.getBean("bookServiceSetter");
        bookServiceSetter.addBook("Setter Book", "Author B");
        
        System.out.println("\nInjection Methods Verified:");
        System.out.println("- Constructor Injection: Working");
        System.out.println("- Setter Injection: Working");
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
    public void save(Book book) {
        System.out.println("Book saved: " + book.getTitle());
    }
}

class BookServiceConstructor {
    private BookRepository bookRepository;
    
    public BookServiceConstructor(BookRepository bookRepository) {
        System.out.println("BookServiceConstructor: Constructor Injection");
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        bookRepository.save(new Book(title, author));
    }
}

class BookServiceSetter {
    private BookRepository bookRepository;
    
    public BookServiceSetter() {
        System.out.println("BookServiceSetter: Default Constructor");
    }
    
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookServiceSetter: Setter Injection");
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        bookRepository.save(new Book(title, author));
    }
}
