import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise1_LoggingErrorAndWarning {
    private static final Logger logger = LoggerFactory.getLogger(Exercise1_LoggingErrorAndWarning.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");
    }

    public void processData(String data) {
        try {
            if (data == null) {
                logger.error("Data is null");
                throw new IllegalArgumentException("Data cannot be null");
            }
            logger.info("Processing data: {}", data);
        } catch (IllegalArgumentException e) {
            logger.error("Error processing data", e);
        }
    }

    public void validateUser(String username) {
        if (username == null || username.isEmpty()) {
            logger.warn("Username is empty or null");
            return;
        }
        logger.info("User validation successful for: {}", username);
    }
}
