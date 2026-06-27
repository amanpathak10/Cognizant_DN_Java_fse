-- Exercise 6 Scenario 2: Apply annual fee to all accounts.
DECLARE
  CURSOR c_accounts IS
    SELECT accountid, balance
      FROM accounts;
BEGIN
  FOR rec IN c_accounts LOOP
    UPDATE accounts
       SET balance = balance - 50
     WHERE accountid = rec.accountid;
  END LOOP;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Annual fee applied to all accounts.');
END;
/