# Exercise 5: Mocking and Stubbing with Multiple Returns - Output Screenshot

## Test Output
```
Test: testMultipleReturns()
Status: PASSED ✓
Message: Multiple return values verified successfully
- First call returned: "First Call"
- Second call returned: "Second Call"
- Third call returned: "Third Call"

Test: testMultipleReturnsWithException()
Status: PASSED ✓
Message: Multiple returns with exception verified successfully
- First call returned: "Success"
- Second call threw RuntimeException as expected
```

## Console Output
```
[INFO] Running DataServiceTest
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 0.178 s
[INFO] BUILD SUCCESS
```

## Verification Details
- First test successfully stubbed multiple consecutive return values
- Second test verified exception thrown on subsequent calls
- thenReturn() and thenThrow() chaining worked correctly
