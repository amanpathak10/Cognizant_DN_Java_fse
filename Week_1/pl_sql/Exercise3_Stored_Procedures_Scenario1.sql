-- Exercise 3 Scenario 1: Process monthly interest for all savings accounts.
CREATE OR REPLACE PROCEDURE process_monthly_interest AS
BEGIN
  FOR rec IN (
    SELECT accountid, balance
      FROM accounts
     WHERE accounttype = 'Savings'
  ) LOOP
    UPDATE accounts
       SET balance = balance + (rec.balance * 0.01)
     WHERE accountid = rec.accountid;
  END LOOP;
  COMMIT;
END process_monthly_interest;
/