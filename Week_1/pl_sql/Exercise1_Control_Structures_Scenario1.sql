-- Exercise 1 Scenario 1: Discount loan interest rates for customers above 60 years old.
DECLARE
  v_customer_id NUMBER := 1;
  v_age NUMBER;
  v_interest_rate NUMBER;
  v_discounted_rate NUMBER;
BEGIN
  SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, c.dob) / 12), l.interestrate
    INTO v_age, v_interest_rate
    FROM customers c
    JOIN loans l ON c.customerid = l.customerid
   WHERE l.loanid = v_customer_id;

  IF v_age > 60 THEN
    v_discounted_rate := v_interest_rate * 0.90;
    UPDATE loans
       SET interestrate = v_discounted_rate
     WHERE loanid = v_customer_id;
    DBMS_OUTPUT.PUT_LINE('Discount applied. New interest rate: ' || v_discounted_rate);
  ELSE
    DBMS_OUTPUT.PUT_LINE('No discount applied. Customer age: ' || v_age);
  END IF;
END;
/