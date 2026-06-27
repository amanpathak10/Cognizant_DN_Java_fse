-- Exercise 4 Scenario 1: Calculate the age of customers for eligibility checks.
CREATE OR REPLACE FUNCTION get_customer_age(
  p_customer_id IN NUMBER
) RETURN NUMBER AS
  v_age NUMBER;
BEGIN
  SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12)
    INTO v_age
    FROM customers
   WHERE customerid = p_customer_id;

  RETURN v_age;
END get_customer_age;
/