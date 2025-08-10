-- ✅ Enable Output
SET SERVEROUTPUT ON;

-- =============================
-- ✅ SCENARIO 1: Customer Package
-- =============================

-- Package Spec
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
  BEGIN
    UPDATE Customers SET Name = p_name, Balance = p_balance, LastModified = SYSDATE WHERE CustomerID = p_id;
  END;

  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
    RETURN v_balance;
  END;
END CustomerManagement;
/

-- ✅ Call and Test
BEGIN
  CustomerManagement.AddCustomer(3, 'Michael King', TO_DATE('1985-12-10','YYYY-MM-DD'), 20000);
  CustomerManagement.UpdateCustomer(3, 'Michael King Jr.', 25000);
  DBMS_OUTPUT.PUT_LINE('Customer Balance: ' || CustomerManagement.GetCustomerBalance(3));
END;
/

-- =============================
-- ✅ SCENARIO 2: Employee Package
-- =============================

-- Package Spec
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_pos VARCHAR2, p_salary NUMBER);
  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE) IS
  BEGIN
    INSERT INTO Employees VALUES (p_id, p_name, p_pos, p_salary, p_dept, p_hire);
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_pos VARCHAR2, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees SET Position = p_pos, Salary = p_salary WHERE EmployeeID = p_id;
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  END;
END EmployeeManagement;
/

-- ✅ Call and Test
BEGIN
  EmployeeManagement.HireEmployee(3, 'Sara Green', 'Analyst', 50000, 'Finance', SYSDATE);
  EmployeeManagement.UpdateEmployee(3, 'Senior Analyst', 55000);
  DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || EmployeeManagement.GetAnnualSalary(3));
END;
/

-- =============================
-- ✅ SCENARIO 3: Account Package
-- =============================

-- Package Spec
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts VALUES (p_id, p_cust_id, p_type, p_balance, SYSDATE);
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;
  END;

  FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT NVL(SUM(Balance), 0) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
    RETURN v_total;
  END;
END AccountOperations;
/

-- ✅ Call and Test
BEGIN
  AccountOperations.OpenAccount(3, 3, 'Savings', 7000);
  AccountOperations.OpenAccount(4, 3, 'Checking', 5000);
  DBMS_OUTPUT.PUT_LINE('Total Balance for Customer 3: ' || AccountOperations.GetTotalBalance(3));
  AccountOperations.CloseAccount(4);
END;
/