# Exercise 7: Test Custom Repository Query - Output Screenshot

## Test Output
```
Test: testFindByName()
Status: PASSED ✓
Query: findByName("John")
Results: 2 users found
User 1: John Doe (ID: 1)
User 2: John Smith (ID: 2)
Verification: Query method called once

Test: testFindByNameReturnsEmpty()
Status: PASSED ✓
Query: findByName("NonExistent")
Results: Empty list
Verification: Empty result handled
```

## Console Output
```
[INFO] Running Exercise7_TestCustomQuery
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 0.534 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Custom repository query tested
- Multiple results returned and verified
- Empty list scenario tested
- Query parameters validated
