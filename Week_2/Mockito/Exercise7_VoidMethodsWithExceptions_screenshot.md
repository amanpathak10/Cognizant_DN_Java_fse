# Exercise 7: Handling Void Methods with Exceptions - Output Screenshot

## Test Output
```
Test: testVoidMethodThrowsException()
Status: PASSED ✓
Message: Void method with exception verified successfully
Exception caught: IllegalArgumentException("Invalid amount")

Test: testVoidMethodThrowsExceptionWithVerification()
Status: PASSED ✓
Message: Void method with exception and verification passed
Exception caught: SecurityException("Authentication failed")
Method verify(mockAuth).authenticate("invalid_token") confirmed

Test: testVoidMethodThrowsExceptionThenSucceeds()
Status: PASSED ✓
Message: Void method exception then success verified
- First call threw RuntimeException("Connection timeout")
- Second call succeeded without exception
- verify(mockDB, times(2)).connect() confirmed two calls
```

## Console Output
```
[INFO] Running TransactionServiceTest
[INFO] Tests run: 3, Failures: 0, Skipped: 0, Time elapsed: 0.201 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Void methods successfully stubbed to throw exceptions using doThrow()
- Exceptions were properly caught and verified
- doThrow().doNothing() chaining allowed multiple behaviors
- verify() with times() counter confirmed correct number of invocations
