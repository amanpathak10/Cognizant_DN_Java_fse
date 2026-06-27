-- Exercise 4 Scenario 2: Compute the monthly installment for a loan.
CREATE OR REPLACE FUNCTION calculate_monthly_installment(
  p_loan_amount IN NUMBER,
  p_interest_rate IN NUMBER,
  p_period_months IN NUMBER
) RETURN NUMBER AS
  v_monthly_rate NUMBER;
  v_installment NUMBER;
BEGIN
  IF p_period_months = 0 THEN
    RETURN NULL;
  END IF;

  v_monthly_rate := p_interest_rate / 12 / 100;
  v_installment := (p_loan_amount * v_monthly_rate) / (1 - POWER(1 + v_monthly_rate, -p_period_months));
  RETURN v_installment;
END calculate_monthly_installment;
/