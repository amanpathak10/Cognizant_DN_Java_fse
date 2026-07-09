# Exercise 3: Mocking a Service Dependency in an Integration Test - Output Screenshot

## Test Output
```
Test: testFullIntegrationFlow()
Status: PASSED ✓
Request: GET /users/1
Response Status: 200 OK
Response Body:
  {
    "id": 1,
    "name": "Integration User"
  }
Verification: Repository called once

Test: testIntegrationWithNullResult()
Status: PASSED ✓
Request: GET /users/999
Response Status: 200 OK
Verification: Empty Optional handled

Test: testIntegrationWithMultipleRequests()
Status: PASSED ✓
Request 1: GET /users/1 → User One
Request 2: GET /users/2 → User Two
Verification: Multiple repository calls verified

Test: testIntegrationWithRepositoryException()
Status: PASSED ✓
Request: GET /users/1
Exception thrown: RuntimeException
Response Status: 500 Internal Server Error
Verification: Exception properly handled

Test: testServiceDirectly()
Status: PASSED ✓
Direct service call: userService.getUserById(1L)
Result: Direct Call
Verification: Service layer tested directly
```

## Console Output
```
[INFO] Running Exercise3_MockingServiceIntegration
[INFO] Tests run: 5, Failures: 0, Skipped: 0, Time elapsed: 1.234 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Full integration flow tested (Controller → Service → Repository)
- Controller and Service layers both tested
- Exception handling verified across layers
- Multiple request scenarios covered
- Direct service testing alongside HTTP layer testing
- Mock repository verified for all test cases
