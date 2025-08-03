DECLARE
-- Cursor for monthly statements
CURSOR cur_monthly_statements IS
SELECT c.CustomerID, c.Name, t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
FROM Customers c
         JOIN Accounts a ON c.CustomerID = a.CustomerID
         JOIN Transactions t ON a.AccountID = t.AccountID
WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
ORDER BY c.CustomerID, t.TransactionDate;

-- Cursor for applying annual fee
CURSOR cur_accounts IS SELECT AccountID, Balance FROM Accounts;

-- Cursor for updating loan interest rates
CURSOR cur_loans IS SELECT LoanID, InterestRate FROM Loans;

v_current_customer Customers.CustomerID%TYPE := NULL;
  v_annual_fee CONSTANT NUMBER := 100;
  v_interest_increase CONSTANT NUMBER := 0.5;

BEGIN
  -- 1. Generate Monthly Statements
  DBMS_OUTPUT.PUT_LINE('--- Monthly Statements ---');
FOR rec IN cur_monthly_statements LOOP
    IF v_current_customer != rec.CustomerID THEN
      DBMS_OUTPUT.PUT_LINE(CHR(10) || 'Customer: ' || rec.Name || ' (ID: ' || rec.CustomerID || ')');
      v_current_customer := rec.CustomerID;
END IF;
    DBMS_OUTPUT.PUT_LINE('Transaction ' || rec.TransactionID || ': ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY') ||
                         ', Amount: ' || rec.Amount || ', Type: ' || rec.TransactionType);
END LOOP;

  -- 2. Apply Annual Fee to All Accounts
FOR rec IN cur_accounts LOOP
UPDATE Accounts
SET Balance = Balance - v_annual_fee,
    LastModified = SYSDATE
WHERE AccountID = rec.AccountID;
END LOOP;
  DBMS_OUTPUT.PUT_LINE(CHR(10) || 'Annual fees applied to all accounts.');

  -- 3. Update Loan Interest Rates
FOR rec IN cur_loans LOOP
UPDATE Loans
SET InterestRate = InterestRate + v_interest_increase
WHERE LoanID = rec.LoanID;
END LOOP;
  DBMS_OUTPUT.PUT_LINE('Loan interest rates updated.');

COMMIT;
END;
/
