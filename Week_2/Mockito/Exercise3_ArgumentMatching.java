import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise3_ArgumentMatching {
    @Test
    public void testArgumentMatching() {
        PaymentGateway mockGateway = Mockito.mock(PaymentGateway.class);
        when(mockGateway.processPayment(anyDouble())).thenReturn(true);
        
        PaymentService service = new PaymentService(mockGateway);
        boolean result = service.pay(100.0);
        
        // Verify that processPayment was called with exactly 100.0
        verify(mockGateway).processPayment(eq(100.0));
    }
    
    @Test
    public void testArgumentMatchingWithAnyString() {
        UserRepository mockRepo = Mockito.mock(UserRepository.class);
        when(mockRepo.findUser(anyString())).thenReturn("User Found");
        
        UserService service = new UserService(mockRepo);
        String result = service.getUser("john");
        
        // Verify that findUser was called with any string argument
        verify(mockRepo).findUser(anyString());
    }
}

interface PaymentGateway {
    boolean processPayment(double amount);
}

interface UserRepository {
    String findUser(String username);
}

class PaymentService {
    private PaymentGateway gateway;
    
    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }
    
    public boolean pay(double amount) {
        return gateway.processPayment(amount);
    }
}

class UserService {
    private UserRepository repository;
    
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    
    public String getUser(String username) {
        return repository.findUser(username);
    }
}
