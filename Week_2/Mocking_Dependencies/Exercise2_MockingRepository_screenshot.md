# Exercise 2: Mocking a Repository in a Service Test - Output Screenshot

## Test Output
```
Test: testGetUserByIdSuccess()
Status: PASSED ✓
Repository.findById(1L) mocked
Result: User(id=1, name=John Doe)
Verification: Repository called once

Test: testGetUserByIdNotFound()
Status: PASSED ✓
Repository.findById(999L) returned Optional.empty()
Result: null
Verification: Repository called once

Test: testGetUserByIdMultipleCalls()
Status: PASSED ✓
First call result: Alice
Second call result: Bob
Verification: Both repository calls verified

Test: testRepositoryException()
Status: PASSED ✓
Exception thrown: RuntimeException("Database error")
Verification: Exception properly propagated
```

## Console Output
```
[INFO] Running Exercise2_MockingRepository
[INFO] Tests run: 4, Failures: 0, Skipped: 0, Time elapsed: 0.523 s
[INFO] BUILD SUCCESS
```

## Verification Details
- UserRepository successfully mocked in service
- Optional handling verified
- Multiple repository calls tested
- Exception handling verified
- Mock assertions validated
