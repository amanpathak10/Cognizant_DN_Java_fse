# Exercise 2: Parameterized Logging - Output Screenshot

## Console Output
```
[INFO]  User john_doe performed action: login
[DEBUG] User ID: 123, Username: john_doe
[WARN]  Multiple login attempts for user: john_doe
[INFO]  User john_doe performed activity: update profile (attempt: 5)
[DEBUG] Database operation: INSERT on table users took 1000 ms
[INFO]  User john_doe performed activity: update profile (attempt: 5)
[DEBUG] Database operation: INSERT on table users took 1000 ms
[INFO]  HTTP GET request to /api/users returned status: 200
[ERROR] Exception in UserService.getUser: User not found
```

## Parameterized Logging Details
```
Format: logger.info("message with {} placeholders", param1, param2)
Benefits: 
- Efficient string concatenation
- Avoids unnecessary string building when log level is disabled
- Cleaner code readability
- Performance optimized
```

## Verification Details
- Single parameter logging works
- Multiple parameter logging works
- Different log levels with parameters verified
- Database operation logging with duration parameter
- HTTP request logging with status codes
- Exception logging with class and method names
- All placeholders properly replaced
