-- Exercise 2 Scenario 2: Manage errors when updating employee salaries.
BEGIN
  UPDATE employees
     SET salary = salary * 1.10
   WHERE employeeid = 3;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee not found for salary update.');
  END IF;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Employee salary updated successfully.');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Salary update error: ' || SQLERRM);
    ROLLBACK;
END;
/