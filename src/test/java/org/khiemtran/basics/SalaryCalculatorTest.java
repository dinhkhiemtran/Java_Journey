package org.khiemtran.basics;

import org.junit.jupiter.api.*;

class SalaryCalculatorTest {
  private SalaryCalculator calculator;

  @BeforeEach
  public void setup() {
    calculator = new SalaryCalculator();
  }

  @Test
  public void testEmployeeSkippedWorkLeastFiveDays() {
    Assertions.assertEquals(1.0, calculator.salaryMultiplier(3));
  }

  @Test
  public void testEmployeeSkippedGreaterThan5Days() {
    Assertions.assertEquals(0.85, calculator.salaryMultiplier(7));
  }

  @Test
  public void testProductSold() {
    Assertions.assertEquals(13, calculator.bonusMultiplier(21));
    Assertions.assertEquals(273, calculator.bonusForProductsSold(21));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The salaryMultiplier method returns 1.0 when daysSkipped is below the threshold")
  public void msalaryMultiplierWhenDaysSkippedIs4() {
    Assertions.assertEquals(1.0, calculator.salaryMultiplier(4));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The salaryMultiplier method returns 0.85 when daysSkipped is equal to the threshold")
  public void salaryMultiplierWhenDaysSkippedIs5() {
    Assertions.assertEquals(0.85, calculator.salaryMultiplier(5));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The bonusMultiplier method returns 0.85 when daysSkipped is above the threshold")
  public void salaryMultiplierWhenDaysSkippedIs6() {
    Assertions.assertEquals(0.85, calculator.salaryMultiplier(6));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The bonusMultiplier method returns 10 when productsSold is below the threshold")
  public void bonusMultiplierWhenProductsSoldIs19() {
    Assertions.assertEquals(10, calculator.bonusMultiplier(19));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The bonusMultiplier method returns 13 when productsSold is equal to the threshold")
  public void bonusMultiplierWhenProductsSoldIs20() {
    Assertions.assertEquals(13, calculator.bonusMultiplier(20));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The bonusMultiplier method returns 13 when productsSold is above the threshold")
  public void bonusMultiplierWhenProductsSoldIs21() {
    Assertions.assertEquals(13, calculator.bonusMultiplier(21));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The bonusForProductsSold method returns the right result")
  public void bonusForProductsSoldWhenProductsSoldIs5() {
    Assertions.assertEquals(50, calculator.bonusForProductsSold(5));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The finalSalary method returns the regular salary without multiplier and bonus")
  public void regularSalary() {
    Assertions.assertEquals(1000.0, calculator.finalSalary(0, 0));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The finalSalary method returns the correct result when daysSkipped above threshold")
  public void skippedAboveThreshold() {
    Assertions.assertEquals(850.0, calculator.finalSalary(7, 0));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The finalSalary method returns the correct result when daysSkipped and productsSold below threshold")
  public void skippedBelowThresholdAndSoldBelowThreshold() {
    Assertions.assertEquals(1050.0, calculator.finalSalary(2, 5));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The finalSalary method returns the correct result capped at maximum salary")
  public void salaryRespectMaximum() {
    Assertions.assertEquals(2000.0, calculator.finalSalary(0, 77));
  }
}