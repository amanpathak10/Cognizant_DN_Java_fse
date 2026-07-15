import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise3_DifferentAppenders {
    private static final Logger logger = LoggerFactory.getLogger(Exercise3_DifferentAppenders.class);

    public static void main(String[] args) {
        logger.debug("Debug message - goes to both console and file");
        logger.info("Info message - goes to both console and file");
        logger.warn("Warning message - goes to both console and file");
        logger.error("Error message - goes to both console and file");

        processTransaction("TXN001", 1500.00);
        processTransaction("TXN002", 2500.00);
        handleError();
    }

    public static void processTransaction(String transactionId, double amount) {
        logger.info("Processing transaction ID: {} with amount: {}", transactionId, amount);
        logger.debug("Transaction details - ID: {}, Amount: {}, Status: Processing", transactionId, amount);
        logger.info("Transaction {} completed successfully", transactionId);
    }

    public static void handleError() {
        try {
            throw new RuntimeException("Database connection failed");
        } catch (RuntimeException e) {
            logger.error("Error occurred during processing", e);
            logger.warn("Attempting to reconnect to database");
        }
    }

    public static void auditLog(String user, String action, String resource) {
        logger.info("Audit - User: {} performed {} on {}", user, action, resource);
    }
}
