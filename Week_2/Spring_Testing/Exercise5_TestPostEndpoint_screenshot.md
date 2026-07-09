# Exercise 5: Test Controller POST Endpoint - Output Screenshot

## Test Output
```
Test: testCreateUser()
Status: PASSED ✓
Request: POST /users
Payload: {"name": "New User"}
Response Status: 201 Created
Response Body:
  {
    "id": 1,
    "name": "New User"
  }

Test: testCreateUserWithValidation()
Status: PASSED ✓
Request: POST /users
Payload: {"name": "Valid User"}
Response Status: 201 Created
```

## Console Output
```
[INFO] Running Exercise5_TestPostEndpoint
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 0.645 s
[INFO] BUILD SUCCESS
```

## Verification Details
- POST endpoint successfully tested
- User creation verified
- JSON request payload processed
- Service method invoked and verified
