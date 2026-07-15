import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise2_ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(Exercise2_ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "john_doe";
        int userId = 123;
        String action = "login";

        logger.info("User {} performed action: {}", username, action);
        logger.debug("User ID: {}, Username: {}", userId, username);
        logger.warn("Multiple login attempts for user: {}", username);

        logUserActivity(username, "update profile", 5);
        logDatabaseOperation("INSERT", "users", 1000);
    }

    public static void logUserActivity(String username, String activity, int attempts) {
        logger.info("User {} performed activity: {} (attempt: {})", username, activity, attempts);
    }

    public static void logDatabaseOperation(String operation, String table, long duration) {
        logger.debug("Database operation: {} on table {} took {} ms", operation, table, duration);
    }

    public static void logRequest(String method, String url, int statusCode) {
        logger.info("HTTP {} request to {} returned status: {}", method, url, statusCode);
    }

    public static void logException(String className, String methodName, Exception e) {
        logger.error("Exception in {}.{}: {}", className, methodName, e.getMessage());
    }
}
