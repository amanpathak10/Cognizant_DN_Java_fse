-- Exercise 5 Scenario 3: Enforce business rules on deposits and withdrawals.
CREATE OR REPLACE TRIGGER trg_account_transactions
  BEFORE INSERT ON transactions
  FOR EACH ROW
DECLARE
  v_account_balance NUMBER;
BEGIN
  SELECT balance
    INTO v_account_balance
    FROM accounts
   WHERE accountid = :NEW.accountid;

  IF :NEW.transactiontype = 'Withdrawal' AND v_account_balance < :NEW.amount THEN
    RAISE_APPLICATION_ERROR(-20020, 'Insufficient balance for withdrawal.');
  END IF;

  IF :NEW.transactiontype = 'Deposit' AND :NEW.amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20021, 'Deposit amount must be greater than zero.');
  END IF;
END trg_account_transactions;
/