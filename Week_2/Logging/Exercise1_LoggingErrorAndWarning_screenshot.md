# Exercise 1: Logging Error Messages and Warning Levels - Output Screenshot

## Console Output
```
[ERROR] This is an error message
[WARN]  This is a warning message
[INFO]  This is an info message
[DEBUG] This is a debug message

[INFO]  Processing data: Sample data
[WARN]  Username is empty or null
[ERROR] Error processing data
java.lang.IllegalArgumentException: Data cannot be null
    at Exercise1_LoggingErrorAndWarning.processData(Exercise1_LoggingErrorAndWarning.java:20)
    at Exercise1_LoggingErrorAndWarning.main(Exercise1_LoggingErrorAndWarning.java:13)
```

## Log Output Details
```
ERROR level: Error messages shown
WARNING level: Warning messages shown
INFO level: Information messages shown
DEBUG level: Debug messages shown
Exception: Full stack trace logged
```

## Verification Details
- Error level logging demonstrated
- Warning level logging demonstrated
- Info level logging demonstrated
- Debug level logging demonstrated
- Exception handling with logging verified
- SLF4J logger initialized successfully
