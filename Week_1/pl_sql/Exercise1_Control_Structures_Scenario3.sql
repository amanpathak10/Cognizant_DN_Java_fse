-- Exercise 1 Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
DECLARE
  CURSOR c_due_loans IS
    SELECT c.customerid,
           c.name,
           l.loanid,
           l.enddate
      FROM customers c
      JOIN loans l ON c.customerid = l.customerid
     WHERE l.enddate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
  FOR rec IN c_due_loans LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder for ' || rec.name || ' (Customer ' || rec.customerid || '): Loan ' || rec.loanid || ' is due on ' || TO_CHAR(rec.enddate, 'YYYY-MM-DD'));
  END LOOP;
END;
/