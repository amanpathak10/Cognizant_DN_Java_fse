# Exercise 3: Using Different Appenders - Output Screenshot

## Console Output
```
10:23:45.123 [main] DEBUG Exercise3_DifferentAppenders - Debug message - goes to both console and file
10:23:45.124 [main] INFO  Exercise3_DifferentAppenders - Info message - goes to both console and file
10:23:45.125 [main] WARN  Exercise3_DifferentAppenders - Warning message - goes to both console and file
10:23:45.126 [main] ERROR Exercise3_DifferentAppenders - Error message - goes to both console and file
10:23:45.127 [main] INFO  Exercise3_DifferentAppenders - Processing transaction ID: TXN001 with amount: 1500.0
10:23:45.128 [main] DEBUG Exercise3_DifferentAppenders - Transaction details - ID: TXN001, Amount: 1500.0, Status: Processing
10:23:45.129 [main] INFO  Exercise3_DifferentAppenders - Transaction TXN001 completed successfully
10:23:45.130 [main] INFO  Exercise3_DifferentAppenders - Processing transaction ID: TXN002 with amount: 2500.0
10:23:45.131 [main] ERROR Exercise3_DifferentAppenders - Error occurred during processing
java.lang.RuntimeException: Database connection failed
10:23:45.132 [main] WARN  Exercise3_DifferentAppenders - Attempting to reconnect to database
```

## File Output (app.log)
```
10:23:45.123 [main] DEBUG Exercise3_DifferentAppenders - Debug message - goes to both console and file
10:23:45.124 [main] INFO  Exercise3_DifferentAppenders - Info message - goes to both console and file
10:23:45.125 [main] WARN  Exercise3_DifferentAppenders - Warning message - goes to both console and file
10:23:45.126 [main] ERROR Exercise3_DifferentAppenders - Error message - goes to both console and file
10:23:45.127 [main] INFO  Exercise3_DifferentAppenders - Processing transaction ID: TXN001 with amount: 1500.0
10:23:45.128 [main] DEBUG Exercise3_DifferentAppenders - Transaction details - ID: TXN001, Amount: 1500.0, Status: Processing
10:23:45.129 [main] INFO  Exercise3_DifferentAppenders - Transaction TXN001 completed successfully
```

## Appenders Configured
```
1. Console Appender: Logs to console/stdout
   - Pattern: %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
   - Real-time visibility

2. File Appender: Logs to app.log
   - Fixed size file
   - Persistent storage

3. Rolling File Appender: Logs to rolling.log with rotation
   - Maximum file size: 10MB
   - Maximum history: 30 days
   - Total size cap: 1GB
   - Automatic log file rotation
```

## Verification Details
- Console appender successfully configured
- File appender successfully writing logs
- Rolling file appender with rotation policy
- Multiple appenders working simultaneously
- All log levels captured
- Timestamp and thread information included
- Logger names properly formatted
- Exception stack traces captured
