--------------------------------------------------------------------------------
-- 🔁 Scenario 1: Process monthly interest for savings accounts (1% interest)
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
UPDATE Accounts
SET Balance = Balance + (Balance * 0.01)
WHERE AccountType = 'Savings';

DBMS_OUTPUT.PUT_LINE(' Monthly interest applied to all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

--------------------------------------------------------------------------------
-- 🎁 Scenario 2: Add bonus to all employees in a given department
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_pct IN NUMBER
) AS
BEGIN
UPDATE Employees
SET Salary = Salary + (Salary * bonus_pct / 100)
WHERE Department = dept_name;

DBMS_OUTPUT.PUT_LINE(' Bonus applied to department: ' || dept_name);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10); -- Example: Add 10% bonus to IT dept
END;
/

--------------------------------------------------------------------------------
-- 🔄 Scenario 3: Transfer funds between two accounts with check
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE TransferFunds (
    source_acc IN NUMBER,
    target_acc IN NUMBER,
    amount     IN NUMBER
) AS
    balance_source NUMBER;
BEGIN
SELECT Balance INTO balance_source FROM Accounts WHERE AccountID = source_acc;

IF balance_source < amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Not enough balance in source account.');
ELSE
UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = source_acc;
UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = target_acc;
DBMS_OUTPUT.PUT_LINE(' Funds transferred successfully.');
END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs do not exist.');
WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

BEGIN
    TransferFunds(1, 2, 500); -- Example test case
END;
/
