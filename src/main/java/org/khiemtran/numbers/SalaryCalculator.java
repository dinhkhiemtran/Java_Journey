package org.khiemtran.numbers;

public class SalaryCalculator {
  private static final double BASE_SALARY = 1000.00;
  private static final double  SALARIES_CAPPED = 2000.00;
  public double salaryMultiplier(int daysSkipped) {
    return daysSkipped >= 5 ? 0.85 : 1.0;
  }

  public int bonusMultiplier(int productsSold) {
    return productsSold < 20 ? 10 : 13;
  }

  public double bonusForProductsSold(int productsSold) {
    return bonusMultiplier(productsSold) * productsSold;
  }

  public double finalSalary(int daysSkipped, int productsSold) {
    double salary = BASE_SALARY * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
    return salary > SALARIES_CAPPED ? SALARIES_CAPPED : salary;
  }
}
