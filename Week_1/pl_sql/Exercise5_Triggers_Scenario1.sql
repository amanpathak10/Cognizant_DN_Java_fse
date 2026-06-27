-- Exercise 5 Scenario 1: Automatically update the last modified date when a customer's record is updated.
CREATE OR REPLACE TRIGGER trg_customers_lastmodified
  BEFORE UPDATE ON customers
  FOR EACH ROW
BEGIN
  :NEW.lastmodified := SYSDATE;
END trg_customers_lastmodified;
/