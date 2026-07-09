# Exercise 6: Test Service Exception Handling - Output Screenshot

## Test Output
```
Test: testGetUserByIdThrowsException()
Status: PASSED ✓
Exception thrown: RuntimeException
Message: User not found
Verified: Exception properly handled

Test: testHandleNullPointerException()
Status: PASSED ✓
Exception thrown: NullPointerException
Message: ID cannot be null
Verified: Null handling works

Test: testGetUserReturnsNullWhenNotFound()
Status: PASSED ✓
Result: null
Expected: null
Verified: Empty Optional handled correctly
```

## Console Output
```
[INFO] Running Exercise6_TestExceptionHandling
[INFO] Tests run: 3, Failures: 0, Skipped: 0, Time elapsed: 0.523 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Exception throwing verified
- Null pointer exception handling tested
- Empty Optional handling tested
- Mock exception injection successful
