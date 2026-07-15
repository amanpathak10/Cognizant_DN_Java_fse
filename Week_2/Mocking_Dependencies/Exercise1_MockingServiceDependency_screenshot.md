# Exercise 1: Mocking a Service Dependency in a Controller Test - Output Screenshot

## Test Output
```
Test: testGetUserEndpoint()
Status: PASSED ✓
Request: GET /users/1
Response Status: 200 OK
Response Body:
  {
    "id": 1,
    "name": "John Doe"
  }
Verification: userService.getUserById(1L) called once

Test: testGetUserNotFound()
Status: PASSED ✓
Request: GET /users/999
Response Status: 200 OK
Verification: userService.getUserById(999L) called once

Test: testMultipleUserCalls()
Status: PASSED ✓
Request: GET /users/1
Response: Alice (ID: 1)
Request: GET /users/2
Response: Bob (ID: 2)
Verification: Both service calls verified
```

## Console Output
```
[INFO] Running Exercise1_MockingServiceDependency
[INFO] Tests run: 3, Failures: 0, Skipped: 0, Time elapsed: 0.645 s
[INFO] BUILD SUCCESS
```

## Verification Details
- UserService dependency successfully mocked in controller test
- Multiple endpoints tested
- JSON response paths validated
- Service method invocations verified
- Mock assertions working correctly
