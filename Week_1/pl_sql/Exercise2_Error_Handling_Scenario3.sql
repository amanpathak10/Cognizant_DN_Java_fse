-- Exercise 2 Scenario 3: Ensure data integrity when adding a new customer.
BEGIN
  INSERT INTO customers (customerid, name, dob, balance, lastmodified)
  VALUES (3, 'Charlie King', TO_DATE('1993-02-10', 'YYYY-MM-DD'), 1200, SYSDATE);

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');
    ROLLBACK;
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Customer insertion failed: ' || SQLERRM);
    ROLLBACK;
END;
/