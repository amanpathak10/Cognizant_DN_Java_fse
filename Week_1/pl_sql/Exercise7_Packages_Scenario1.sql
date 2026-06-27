-- Exercise 7 Scenario 1: Group all customer-related procedures and functions into a package.
CREATE OR REPLACE PACKAGE customer_pkg AS
  PROCEDURE update_customer_balance(p_customer_id IN NUMBER, p_amount IN NUMBER);
  FUNCTION get_customer_balance(p_customer_id IN NUMBER) RETURN NUMBER;
END customer_pkg;
/

CREATE OR REPLACE PACKAGE BODY customer_pkg AS
  PROCEDURE update_customer_balance(p_customer_id IN NUMBER, p_amount IN NUMBER) AS
  BEGIN
    UPDATE customers
       SET balance = NVL(balance, 0) + p_amount,
           lastmodified = SYSDATE
     WHERE customerid = p_customer_id;
    COMMIT;
  END update_customer_balance;

  FUNCTION get_customer_balance(p_customer_id IN NUMBER) RETURN NUMBER AS
    v_balance NUMBER;
  BEGIN
    SELECT balance
      INTO v_balance
      FROM customers
     WHERE customerid = p_customer_id;
    RETURN v_balance;
  END get_customer_balance;
END customer_pkg;
/