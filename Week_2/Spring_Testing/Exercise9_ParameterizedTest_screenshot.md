# Exercise 9: Parameterized Test with JUnit - Output Screenshot

## Test Output
```
Test: testAddWithMultipleInputs[1]
Status: PASSED ✓
Input: 1
Result: 2

Test: testAddWithMultipleInputs[2]
Status: PASSED ✓
Input: 2
Result: 3

Test: testAddWithMultipleInputs[3]
Status: PASSED ✓
Input: 3
Result: 4

Test: testAddWithMultipleValues[1, 1, 2]
Status: PASSED ✓
Expected: 2, Actual: 2

Test: testAddWithMultipleValues[2, 3, 5]
Status: PASSED ✓
Expected: 5, Actual: 5

Test: testAddWithMultipleValues[10, 5, 15]
Status: PASSED ✓
Expected: 15, Actual: 15

Test: testAddWithMultipleValues[-1, -1, -2]
Status: PASSED ✓
Expected: -2, Actual: -2

Test: testAddWithMultipleValues[0, 0, 0]
Status: PASSED ✓
Expected: 0, Actual: 0

Test: testUserNames[John]
Status: PASSED ✓

Test: testUserNames[Jane]
Status: PASSED ✓

Test: testUserNames[Bob]
Status: PASSED ✓
```

## Console Output
```
[INFO] Running Exercise9_ParameterizedTest
[INFO] Tests run: 13, Failures: 0, Skipped: 0, Time elapsed: 0.456 s
[INFO] BUILD SUCCESS
```

## Verification Details
- Parameterized tests with multiple inputs executed
- @ValueSource annotation tested
- @CsvSource annotation tested
- All 13 test cases passed
- Multiple scenarios covered with single test method
