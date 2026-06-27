-- Exercise 2 Scenario 1: Handle exceptions during fund transfers between accounts.
DECLARE
  v_from_account NUMBER := 1;
  v_to_account NUMBER := 2;
  v_amount NUMBER := 500;
  v_from_balance NUMBER;
BEGIN
  SELECT balance
    INTO v_from_balance
    FROM accounts
   WHERE accountid = v_from_account;

  IF v_from_balance < v_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for transfer.');
  END IF;

  UPDATE accounts
     SET balance = balance - v_amount
   WHERE accountid = v_from_account;

  UPDATE accounts
     SET balance = balance + v_amount
   WHERE accountid = v_to_account;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Account not found.');
    ROLLBACK;
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
    ROLLBACK;
END;
/