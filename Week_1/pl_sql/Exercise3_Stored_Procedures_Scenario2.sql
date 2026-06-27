-- Exercise 3 Scenario 2: Implement a bonus scheme for employees based on performance.
CREATE OR REPLACE PROCEDURE award_employee_bonus AS
BEGIN
  FOR rec IN (
    SELECT employeeid, salary
      FROM employees
     WHERE department = 'Sales'
  ) LOOP
    UPDATE employees
       SET salary = salary + (rec.salary * 0.05)
     WHERE employeeid = rec.employeeid;
  END LOOP;
  COMMIT;
END award_employee_bonus;
/