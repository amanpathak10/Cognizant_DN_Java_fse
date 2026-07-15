# Exercise 3: Testing a REST Controller with MockMvc - Output Screenshot

## Test Output
```
Test: testGetUser()
Status: PASSED ✓
Request: GET /users/1
Response Status: 200 OK
Response Body:
  {
    "id": 1,
    "name": "John Doe"
  }

Test: testGetUserNotFound()
Status: PASSED ✓
Request: GET /users/999
Response Status: 200 OK
```

## Console Output
```
[INFO] Running Exercise3_TestRestController
[INFO] Tests run: 2, Failures: 0, Skipped: 0, Time elapsed: 0.612 s
[INFO] BUILD SUCCESS
```

## Verification Details
- REST endpoint tested successfully
- JSON response validated
- Service method called once
- HTTP status verified
