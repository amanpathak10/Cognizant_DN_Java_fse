# Exercise 2: Mocking a Repository in a Service Test - Output Screenshot

## Test Output
```
Test: testGetUserById()
Status: PASSED ✓
User Retrieved: John Doe
Verification: findById(1L) called once

Test: testGetUserByIdNotFound()
Status: PASSED ✓
Result: null
Verification: findById(999L) called once
```

## Console Output
```
[INFO] Running Exercise2_MockingRepository
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 0.567 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Repository mock successfully created
- User found scenario tested
- User not found scenario tested
- Mock method invocations verified
