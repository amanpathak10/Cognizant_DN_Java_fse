-- Exercise 7 Scenario 2: Create a package to manage employee data.
CREATE OR REPLACE PACKAGE employee_pkg AS
  PROCEDURE award_bonus(p_employee_id IN NUMBER, p_percentage IN NUMBER);
  FUNCTION get_employee_department(p_employee_id IN NUMBER) RETURN VARCHAR2;
END employee_pkg;
/

CREATE OR REPLACE PACKAGE BODY employee_pkg AS
  PROCEDURE award_bonus(p_employee_id IN NUMBER, p_percentage IN NUMBER) AS
  BEGIN
    UPDATE employees
       SET salary = salary + (salary * p_percentage / 100)
     WHERE employeeid = p_employee_id;
    COMMIT;
  END award_bonus;

  FUNCTION get_employee_department(p_employee_id IN NUMBER) RETURN VARCHAR2 AS
    v_department VARCHAR2(50);
  BEGIN
    SELECT department
      INTO v_department
      FROM employees
     WHERE employeeid = p_employee_id;
    RETURN v_department;
  END get_employee_department;
END employee_pkg;
/