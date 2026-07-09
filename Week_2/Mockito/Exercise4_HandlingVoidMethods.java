import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Exercise4_HandlingVoidMethods {
    @Test
    public void testVoidMethod() {
        EmailClient mockClient = Mockito.mock(EmailClient.class);
        doNothing().when(mockClient).sendEmail(anyString(), anyString());
        
        EmailService service = new EmailService(mockClient);
        service.notifyUser("user@example.com", "Hello");
        
        // Verify that sendEmail was called
        verify(mockClient).sendEmail("user@example.com", "Hello");
    }
    
    @Test
    public void testVoidMethodWithAnswer() {
        LoggerService mockLogger = Mockito.mock(LoggerService.class);
        doAnswer(invocation -> {
            System.out.println("Logging: " + invocation.getArgument(0));
            return null;
        }).when(mockLogger).log(anyString());
        
        NotificationService service = new NotificationService(mockLogger);
        service.sendNotification("Test notification");
        
        // Verify that log was called
        verify(mockLogger).log("Test notification");
    }
}

interface EmailClient {
    void sendEmail(String to, String message);
}

interface LoggerService {
    void log(String message);
}

class EmailService {
    private EmailClient client;
    
    public EmailService(EmailClient client) {
        this.client = client;
    }
    
    public void notifyUser(String email, String message) {
        client.sendEmail(email, message);
    }
}

class NotificationService {
    private LoggerService logger;
    
    public NotificationService(LoggerService logger) {
        this.logger = logger;
    }
    
    public void sendNotification(String message) {
        logger.log(message);
    }
}
