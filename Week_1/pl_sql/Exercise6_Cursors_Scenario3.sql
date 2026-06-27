-- Exercise 6 Scenario 3: Update the interest rate for all loans based on a new policy.
DECLARE
  CURSOR c_loans IS
    SELECT loanid, interestrate
      FROM loans;
BEGIN
  FOR rec IN c_loans LOOP
    UPDATE loans
       SET interestrate = rec.interestrate + 0.5
     WHERE loanid = rec.loanid;
  END LOOP;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Interest rates updated for all loans.');
END;
/