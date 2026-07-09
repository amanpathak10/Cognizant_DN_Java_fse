import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.InOrder;

public class Exercise6_VerifyingInteractionOrder {
    @Test
    public void testInteractionOrder() {
        Database mockDB = Mockito.mock(Database.class);
        Logger mockLogger = Mockito.mock(Logger.class);
        
        OrderService service = new OrderService(mockDB, mockLogger);
        service.processOrder("ORDER123");
        
        // Verify the order of interactions
        InOrder inOrder = inOrder(mockDB, mockLogger);
        inOrder.verify(mockLogger).log("Processing order");
        inOrder.verify(mockDB).saveOrder("ORDER123");
        inOrder.verify(mockLogger).log("Order processed");
    }
    
    @Test
    public void testInteractionOrderWithMultipleCalls() {
        PaymentServiceInterface mockPayment = Mockito.mock(PaymentServiceInterface.class);
        NotificationServiceInterface mockNotification = Mockito.mock(NotificationServiceInterface.class);
        
        CheckoutService service = new CheckoutService(mockPayment, mockNotification);
        service.checkout("user123", 100.0);
        
        // Verify specific order of calls
        InOrder inOrder = inOrder(mockPayment, mockNotification);
        inOrder.verify(mockPayment).charge(100.0);
        inOrder.verify(mockNotification).sendConfirmation("user123");
    }
}

interface Database {
    void saveOrder(String orderId);
}

interface Logger {
    void log(String message);
}

interface PaymentServiceInterface {
    void charge(double amount);
}

interface NotificationServiceInterface {
    void sendConfirmation(String userId);
}

class OrderService {
    private Database database;
    private Logger logger;
    
    public OrderService(Database database, Logger logger) {
        this.database = database;
        this.logger = logger;
    }
    
    public void processOrder(String orderId) {
        logger.log("Processing order");
        database.saveOrder(orderId);
        logger.log("Order processed");
    }
}

class CheckoutService {
    private PaymentServiceInterface paymentService;
    private NotificationServiceInterface notificationService;
    
    public CheckoutService(PaymentServiceInterface paymentService, NotificationServiceInterface notificationService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }
    
    public void checkout(String userId, double amount) {
        paymentService.charge(amount);
        notificationService.sendConfirmation(userId);
    }
}
