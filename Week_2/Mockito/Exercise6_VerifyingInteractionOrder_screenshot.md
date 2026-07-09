# Exercise 6: Verifying Interaction Order - Output Screenshot

## Test Output
```
Test: testInteractionOrder()
Status: PASSED ✓
Message: Interaction order verified successfully
- Logger.log("Processing order") called first
- Database.saveOrder("ORDER123") called second
- Logger.log("Order processed") called third

Test: testInteractionOrderWithMultipleCalls()
Status: PASSED ✓
Message: Interaction order with multiple services verified successfully
- PaymentService.charge(100.0) called first
- NotificationService.sendConfirmation("user123") called second
```

## Console Output
```
[INFO] Running OrderServiceTest
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 0.189 s
[INFO] BUILD SUCCESS
```

## Verification Details
- InOrder verification ensured correct sequence of method calls
- Multiple mock objects interactions were verified in expected order
- Test caught any out-of-order method invocations
