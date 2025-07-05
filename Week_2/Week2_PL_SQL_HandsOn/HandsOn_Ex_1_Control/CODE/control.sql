
-- ✅ Scenario 1: Apply 1% discount to interest rates for customers above 60
BEGIN
  FOR cust IN (
    SELECT c.CustomerID, l.LoanID, l.InterestRate, c.DOB
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
  ) LOOP
    IF MONTHS_BETWEEN(SYSDATE, cust.DOB)/12 > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = cust.LoanID;
    END IF;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('Discount applied for senior customers.');
END;
/

-- ✅ Scenario 2: Promote to VIP if balance > 10000
BEGIN
  EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP VARCHAR2(5))';
EXCEPTION
  WHEN OTHERS THEN NULL; -- Ignore if column already exists
END;
/

BEGIN
  UPDATE Customers
  SET IsVIP = 'TRUE'
  WHERE Balance > 10000;
  DBMS_OUTPUT.PUT_LINE('VIP flags updated.');
END;
/

-- ✅ Scenario 3: Remind customers with loans due in next 30 days
BEGIN
  FOR due_loan IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans l
    JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE l.EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(' Reminder: Loan ID ' || due_loan.LoanID || ' for ' || due_loan.Name ||
                         ' is due on ' || TO_CHAR(due_loan.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
