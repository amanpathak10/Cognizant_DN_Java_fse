import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise7_VoidMethodsWithExceptions {
    @Test
    public void testVoidMethodThrowsException() {
        PaymentProcessor mockProcessor = Mockito.mock(PaymentProcessor.class);
        
        // Stub void method to throw exception
        doThrow(new IllegalArgumentException("Invalid amount"))
            .when(mockProcessor).processPayment(anyDouble());
        
        TransactionService service = new TransactionService(mockProcessor);
        
        // Verify that exception is thrown
        try {
            service.processTransaction(0.0);
        } catch (IllegalArgumentException e) {
            assert e.getMessage().equals("Invalid amount");
        }
    }
    
    @Test
    public void testVoidMethodThrowsExceptionWithVerification() {
        AuthenticationService mockAuth = Mockito.mock(AuthenticationService.class);
        
        // Stub void method to throw exception
        doThrow(new SecurityException("Authentication failed"))
            .when(mockAuth).authenticate(anyString());
        
        SecurityManager service = new SecurityManager(mockAuth);
        
        // Verify that authenticate was called and exception was thrown
        try {
            service.login("invalid_token");
        } catch (SecurityException e) {
            assert e.getMessage().equals("Authentication failed");
        }
        
        // Verify the method was called
        verify(mockAuth).authenticate("invalid_token");
    }
    
    @Test
    public void testVoidMethodThrowsExceptionThenSucceeds() {
        DatabaseService mockDB = Mockito.mock(DatabaseService.class);
        
        // Stub to throw exception on first call, succeed on second
        doThrow(new RuntimeException("Connection timeout"))
            .doNothing()
            .when(mockDB).connect();
        
        ConnectionManager manager = new ConnectionManager(mockDB);
        
        // First call throws exception
        try {
            manager.establishConnection();
        } catch (RuntimeException e) {
            assert e.getMessage().equals("Connection timeout");
        }
        
        // Second call succeeds
        manager.establishConnection(); // Should not throw
        
        // Verify both calls
        verify(mockDB, times(2)).connect();
    }
}

interface PaymentProcessor {
    void processPayment(double amount);
}

interface AuthenticationService {
    void authenticate(String token);
}

interface DatabaseService {
    void connect();
}

class TransactionService {
    private PaymentProcessor processor;
    
    public TransactionService(PaymentProcessor processor) {
        this.processor = processor;
    }
    
    public void processTransaction(double amount) {
        processor.processPayment(amount);
    }
}

class SecurityManager {
    private AuthenticationService authService;
    
    public SecurityManager(AuthenticationService authService) {
        this.authService = authService;
    }
    
    public void login(String token) {
        authService.authenticate(token);
    }
}

class ConnectionManager {
    private DatabaseService dbService;
    
    public ConnectionManager(DatabaseService dbService) {
        this.dbService = dbService;
    }
    
    public void establishConnection() {
        dbService.connect();
    }
}
