-- Schema creation for bank PL/SQL exercises
CREATE TABLE customers (
  customerid NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  dob DATE,
  balance NUMBER,
  lastmodified DATE
);

CREATE TABLE accounts (
  accountid NUMBER PRIMARY KEY,
  customerid NUMBER,
  accounttype VARCHAR2(20),
  balance NUMBER,
  lastmodified DATE,
  CONSTRAINT fk_accounts_customers FOREIGN KEY (customerid) REFERENCES customers(customerid)
);

CREATE TABLE transactions (
  transactionid NUMBER PRIMARY KEY,
  accountid NUMBER,
  transactiondate DATE,
  amount NUMBER,
  transactiontype VARCHAR2(10),
  CONSTRAINT fk_transactions_accounts FOREIGN KEY (accountid) REFERENCES accounts(accountid)
);

CREATE TABLE loans (
  loanid NUMBER PRIMARY KEY,
  customerid NUMBER,
  loanamount NUMBER,
  interestrate NUMBER,
  startdate DATE,
  enddate DATE,
  CONSTRAINT fk_loans_customers FOREIGN KEY (customerid) REFERENCES customers(customerid)
);

CREATE TABLE employees (
  employeeid NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  position VARCHAR2(50),
  salary NUMBER,
  department VARCHAR2(50),
  hiredate DATE
);

CREATE SEQUENCE transaction_audit_seq START WITH 1;

CREATE TABLE transaction_audit (
  audit_id NUMBER PRIMARY KEY,
  transactionid NUMBER,
  accountid NUMBER,
  transactiondate DATE,
  amount NUMBER,
  transactiontype VARCHAR2(10),
  audit_timestamp DATE
);

-- Sample data insertion
INSERT INTO customers (customerid, name, dob, balance, lastmodified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO customers (customerid, name, dob, balance, lastmodified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO accounts (accountid, customerid, accounttype, balance, lastmodified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO accounts (accountid, customerid, accounttype, balance, lastmodified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO transactions (transactionid, accountid, transactiondate, amount, transactiontype)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO transactions (transactionid, accountid, transactiondate, amount, transactiontype)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO loans (loanid, customerid, loanamount, interestrate, startdate, enddate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO employees (employeeid, name, position, salary, department, hiredate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO employees (employeeid, name, position, salary, department, hiredate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;
/