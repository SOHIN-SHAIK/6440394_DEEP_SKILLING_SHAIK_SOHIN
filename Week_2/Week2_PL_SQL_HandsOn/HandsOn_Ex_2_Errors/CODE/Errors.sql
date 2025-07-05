--------------------------------------------------------------------------------
-- 🔐 Scenario 1: Safe fund transfer with error handling
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    from_acc_id IN NUMBER,
    to_acc_id   IN NUMBER,
    amount      IN NUMBER
) AS
    insufficient_balance EXCEPTION;
    from_balance NUMBER;
BEGIN
    SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_acc_id;

    IF from_balance < amount THEN
        RAISE insufficient_balance;
    END IF;

    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_acc_id;
    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_acc_id;

    DBMS_OUTPUT.PUT_LINE('✔ Funds transferred successfully.');

EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
        ROLLBACK;
END;
/

BEGIN
    SafeTransferFunds(1, 2, 2000);  -- Test case
END;
/

--------------------------------------------------------------------------------
-- 🛠️ Scenario 2: Update salary with employee existence check
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE UpdateSalary (
    emp_id     IN NUMBER,
    increment  IN NUMBER
) AS
    current_salary NUMBER;
BEGIN
    SELECT Salary INTO current_salary FROM Employees WHERE EmployeeID = emp_id;

    UPDATE Employees
    SET Salary = current_salary + (current_salary * increment / 100)
    WHERE EmployeeID = emp_id;

    DBMS_OUTPUT.PUT_LINE('✔ Salary updated successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

BEGIN
    UpdateSalary(99, 10);  -- Test with non-existing ID
END;
/

--------------------------------------------------------------------------------
-- 🧾 Scenario 3: Add new customer with duplicate ID check
--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    id     IN NUMBER,
    name   IN VARCHAR2,
    dob    IN DATE,
    bal    IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (id, name, dob, bal, SYSDATE);

    DBMS_OUTPUT.PUT_LINE('✔ Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/

BEGIN
    AddNewCustomer(1, 'Alice', TO_DATE('1995-01-01','YYYY-MM-DD'), 5000);  -- Test duplicate ID
END;
/
