-- Exercise 6 Scenario 1: Generate monthly statements for all customers.
DECLARE
  CURSOR c_customers IS
    SELECT customerid, name
      FROM customers;

  v_total_balance NUMBER;
BEGIN
  FOR c_rec IN c_customers LOOP
    SELECT SUM(balance)
      INTO v_total_balance
      FROM accounts
     WHERE customerid = c_rec.customerid;

    DBMS_OUTPUT.PUT_LINE('Monthly statement for ' || c_rec.name || ' (Customer ' || c_rec.customerid || '): Total balance = ' || NVL(v_total_balance, 0));
  END LOOP;
END;
/