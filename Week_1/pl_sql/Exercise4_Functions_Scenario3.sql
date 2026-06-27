-- Exercise 4 Scenario 3: Check if a customer has sufficient balance before making a transaction.
CREATE OR REPLACE FUNCTION has_sufficient_balance(
  p_account_id IN NUMBER,
  p_amount IN NUMBER
) RETURN VARCHAR2 AS
  v_balance NUMBER;
BEGIN
  SELECT balance
    INTO v_balance
    FROM accounts
   WHERE accountid = p_account_id;

  IF v_balance >= p_amount THEN
    RETURN 'YES';
  ELSE
    RETURN 'NO';
  END IF;
END has_sufficient_balance;
/