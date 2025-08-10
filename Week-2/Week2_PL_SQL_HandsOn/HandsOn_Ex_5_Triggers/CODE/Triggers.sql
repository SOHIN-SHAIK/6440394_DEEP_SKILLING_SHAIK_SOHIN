--------------------------------------------------------------------------------
-- 🔁 Scenario 1: Update LastModified when customer record is updated
--------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
                  FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
-- ✅ Now, any UPDATE on Customers auto-updates LastModified

--------------------------------------------------------------------------------
-- 📝 Scenario 2: Audit log trigger on Transactions
--------------------------------------------------------------------------------
-- Create audit log table first
BEGIN
EXECUTE IMMEDIATE '
CREATE TABLE AuditLog (
                          AuditID NUMBER GENERATED ALWAYS AS IDENTITY,
                          AccountID NUMBER,
                          ActionType VARCHAR2(20),
                          ActionTime DATE
)';
EXCEPTION
    WHEN OTHERS THEN NULL; -- Ignore if already created
END;
/

-- Create trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
INSERT INTO AuditLog (AccountID, ActionType, ActionTime)
VALUES (:NEW.AccountID, 'INSERT', SYSDATE);
END;
/

--------------------------------------------------------------------------------
-- 🛡️ Scenario 3: Prevent invalid withdrawals and deposits
--------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
current_balance NUMBER;
BEGIN
SELECT Balance INTO current_balance
FROM Accounts
WHERE AccountID = :NEW.AccountID;

IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > current_balance THEN
        RAISE_APPLICATION_ERROR(-20001, ' Error: Withdrawal exceeds balance.');
    ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, ' Error: Deposit amount must be positive.');
END IF;
END;
/
