-- Exercise 1 Scenario 2: Promote a customer to VIP status based on their balance.
DECLARE
  v_customer_id NUMBER := 2;
  v_balance NUMBER;
  v_status VARCHAR2(10);
BEGIN
  SELECT balance
    INTO v_balance
    FROM customers
   WHERE customerid = v_customer_id;

  IF v_balance >= 10000 THEN
    v_status := 'VIP';
  ELSE
    v_status := 'NORMAL';
  END IF;

  DBMS_OUTPUT.PUT_LINE('Customer ' || v_customer_id || ' balance is ' || v_balance || '. Status: ' || v_status);
END;
/