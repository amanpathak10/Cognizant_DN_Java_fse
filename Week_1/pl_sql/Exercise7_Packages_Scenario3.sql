-- Exercise 7 Scenario 3: Group all account-related operations into a package.
CREATE OR REPLACE PACKAGE account_pkg AS
  PROCEDURE deposit(p_account_id IN NUMBER, p_amount IN NUMBER);
  PROCEDURE withdraw(p_account_id IN NUMBER, p_amount IN NUMBER);
  FUNCTION get_account_balance(p_account_id IN NUMBER) RETURN NUMBER;
END account_pkg;
/

CREATE OR REPLACE PACKAGE BODY account_pkg AS
  PROCEDURE deposit(p_account_id IN NUMBER, p_amount IN NUMBER) AS
  BEGIN
    UPDATE accounts
       SET balance = balance + p_amount,
           lastmodified = SYSDATE
     WHERE accountid = p_account_id;
    COMMIT;
  END deposit;

  PROCEDURE withdraw(p_account_id IN NUMBER, p_amount IN NUMBER) AS
    v_balance NUMBER;
  BEGIN
    SELECT balance
      INTO v_balance
      FROM accounts
     WHERE accountid = p_account_id;

    IF v_balance < p_amount THEN
      RAISE_APPLICATION_ERROR(-20030, 'Insufficient account balance.');
    END IF;

    UPDATE accounts
       SET balance = balance - p_amount,
           lastmodified = SYSDATE
     WHERE accountid = p_account_id;
    COMMIT;
  END withdraw;

  FUNCTION get_account_balance(p_account_id IN NUMBER) RETURN NUMBER AS
    v_balance NUMBER;
  BEGIN
    SELECT balance
      INTO v_balance
      FROM accounts
     WHERE accountid = p_account_id;
    RETURN v_balance;
  END get_account_balance;
END account_pkg;
/