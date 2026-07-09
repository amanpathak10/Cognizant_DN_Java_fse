import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Exercise8_BasicAOP {
    
    @Before("execution(* BookService.addBook(..))")
    public void beforeAddBook() {
        System.out.println("Before Advice: About to add a book");
    }
    
    @AfterReturning("execution(* BookService.addBook(..))")
    public void afterAddBook() {
        System.out.println("After Returning Advice: Book added successfully");
    }
    
    @Around("execution(* BookService.*(..))")
    public Object aroundBookService(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Advice: Before - " + joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed();
        
        System.out.println("Around Advice: After - " + joinPoint.getSignature().getName());
        return result;
    }
    
    @AfterThrowing("execution(* BookService.*(..))")
    public void afterThrowingBookService() {
        System.out.println("After Throwing Advice: Exception occurred");
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
        System.out.println("Repository: Saving " + book.getTitle());
    }
}

class BookService {
    private BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void addBook(String title, String author) {
        System.out.println("Service: Adding book - " + title);
        bookRepository.save(new Book(title, author));
    }
    
    public void updateBook(String title) {
        System.out.println("Service: Updating book - " + title);
    }
}
