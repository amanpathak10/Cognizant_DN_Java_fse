import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Exercise3_LoggingAspect {
    
    @Around("execution(* BookService.*(..))")
    public Object logMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        System.out.println("Method Start: " + joinPoint.getSignature().getName());
        
        Object result = joinPoint.proceed();
        
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        
        System.out.println("Method End: " + joinPoint.getSignature().getName());
        System.out.println("Execution Time: " + executionTime + " ms");
        
        return result;
    }
}

class BookService {
    public void addBook(String title, String author) {
        System.out.println("Adding book: " + title);
    }
    
    public void displayBooks() {
        System.out.println("Displaying all books");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public int getTotalBooks() {
        System.out.println("Getting total count");
        return 5;
    }
}
