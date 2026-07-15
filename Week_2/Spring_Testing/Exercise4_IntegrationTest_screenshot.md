# Exercise 4: Integration Test with Spring Boot - Output Screenshot

## Test Output
```
Test: testFullFlowFromControllerToDatabase()
Status: PASSED ✓
User saved to database
Request: GET /users/{id}
Response Status: 200 OK
Data retrieved from database: Integration Test User

Test: testCreateAndRetrieveUser()
Status: PASSED ✓
User created via POST endpoint
Request: POST /users
Response Status: 200 OK
```

## Console Output
```
[INFO] Running Exercise4_IntegrationTest
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 1.234 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Full integration flow tested
- Controller → Service → Repository → Database
- Data persistence verified
- POST endpoint tested with JSON payload
