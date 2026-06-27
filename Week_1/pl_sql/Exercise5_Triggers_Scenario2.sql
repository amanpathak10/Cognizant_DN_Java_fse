-- Exercise 5 Scenario 2: Maintain an audit log for all transactions.
CREATE TABLE transaction_audit (
  audit_id NUMBER PRIMARY KEY,
  transactionid NUMBER,
  accountid NUMBER,
  transactiondate DATE,
  amount NUMBER,
  transactiontype VARCHAR2(10),
  audit_timestamp DATE
);

CREATE OR REPLACE TRIGGER trg_transactions_audit
  AFTER INSERT OR UPDATE OR DELETE ON transactions
  FOR EACH ROW
BEGIN
  IF INSERTING THEN
    INSERT INTO transaction_audit (audit_id, transactionid, accountid, transactiondate, amount, transactiontype, audit_timestamp)
    VALUES (transaction_audit_seq.NEXTVAL, :NEW.transactionid, :NEW.accountid, :NEW.transactiondate, :NEW.amount, :NEW.transactiontype, SYSDATE);
  ELSIF UPDATING THEN
    INSERT INTO transaction_audit (audit_id, transactionid, accountid, transactiondate, amount, transactiontype, audit_timestamp)
    VALUES (transaction_audit_seq.NEXTVAL, :NEW.transactionid, :NEW.accountid, :NEW.transactiondate, :NEW.amount, :NEW.transactiontype, SYSDATE);
  ELSIF DELETING THEN
    INSERT INTO transaction_audit (audit_id, transactionid, accountid, transactiondate, amount, transactiontype, audit_timestamp)
    VALUES (transaction_audit_seq.NEXTVAL, :OLD.transactionid, :OLD.accountid, :OLD.transactiondate, :OLD.amount, :OLD.transactiontype, SYSDATE);
  END IF;
END trg_transactions_audit;
/