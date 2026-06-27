-- Exercise 3 Scenario 3: Customers should be able to transfer funds between their accounts.
CREATE OR REPLACE PROCEDURE transfer_funds(
  p_from_account_id IN NUMBER,
  p_to_account_id IN NUMBER,
  p_amount IN NUMBER
) AS
  v_from_balance NUMBER;
BEGIN
  SELECT balance
    INTO v_from_balance
    FROM accounts
   WHERE accountid = p_from_account_id;

  IF v_from_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20010, 'Insufficient funds for transfer.');
  END IF;

  UPDATE accounts
     SET balance = balance - p_amount
   WHERE accountid = p_from_account_id;

  UPDATE accounts
     SET balance = balance + p_amount
   WHERE accountid = p_to_account_id;

  COMMIT;
END transfer_funds;
/