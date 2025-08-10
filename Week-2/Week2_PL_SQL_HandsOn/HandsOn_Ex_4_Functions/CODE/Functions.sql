--------------------------------------------------------------------------------
-- 🧮 Scenario 1: Calculate age from DOB
--------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION CalculateAge (
    dob DATE
) RETURN NUMBER AS
BEGIN
RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, dob) / 12);
END;
/

-- ▶️ Test
BEGIN
    DBMS_OUTPUT.PUT_LINE('Age is: ' || CalculateAge(TO_DATE('1980-05-10','YYYY-MM-DD')));
END;
/

--------------------------------------------------------------------------------
-- 🧾 Scenario 2: Calculate monthly installment for loan
-- Formula: P * r * (1 + r)^n / ((1 + r)^n - 1)
--------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    loan_amount    IN NUMBER,
    annual_rate    IN NUMBER,
    duration_years IN NUMBER
) RETURN NUMBER AS
    r NUMBER := annual_rate / (12 * 100); -- monthly interest rate
    n NUMBER := duration_years * 12;      -- total months
BEGIN
RETURN ROUND(loan_amount * r * POWER(1 + r, n) / (POWER(1 + r, n) - 1), 2);
END;
/

-- ▶️ Test
BEGIN
    DBMS_OUTPUT.PUT_LINE('EMI: ' || CalculateMonthlyInstallment(100000, 8, 5));
END;
/

--------------------------------------------------------------------------------
-- 💰 Scenario 3: Check sufficient balance
--------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    acc_id IN NUMBER,
    amt    IN NUMBER
) RETURN BOOLEAN AS
    bal NUMBER;
BEGIN
SELECT Balance INTO bal FROM Accounts WHERE AccountID = acc_id;

RETURN bal >= amt;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
WHEN OTHERS THEN
        RETURN FALSE;
END;
/

-- ▶️ Test
DECLARE
result BOOLEAN;
BEGIN
    result := HasSufficientBalance(1, 500);

    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
ELSE
        DBMS_OUTPUT.PUT_LINE('Not enough balance.');
END IF;
END;
/
