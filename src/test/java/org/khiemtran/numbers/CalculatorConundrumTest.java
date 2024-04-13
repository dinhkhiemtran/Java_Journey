package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.numbers.CalculatorConundrum;

class CalculatorConundrumTest {
  @Test
  @Tag("task:1")
  @DisplayName("The calculate method returns the correct result when adding small operands")
  public void additionWithSmallOperands() {
    Assertions.assertEquals("22 + 25 = 47", new CalculatorConundrum().calculate(22, 25, "+"));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The calculate method throws IllegalOperationException when passing invalid operation")
  public void throwExceptionForUnknownOperation() {
    String invalidOperation = "**";
    String expectedMessage = "Operation '" + invalidOperation + "' does not exist";
    var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new CalculatorConundrum().calculate(3, 78, invalidOperation);
    });
    Assertions.assertEquals(expectedMessage, exception.getMessage());
  }

  @Test
  @Tag("task:1")
  @DisplayName("The calculate method returns the correct result when adding large operands")
  public void additionWithLargeOperands() {
    Assertions.assertEquals("378961 + 399635 = 778596", new CalculatorConundrum().calculate(378_961, 399_635, "+"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The calculate method returns the correct result when multiplying small operands")
  public void multiplicationWithSmallOperands() {
    Assertions.assertEquals("3 * 21 = 63", new CalculatorConundrum().calculate(3, 21, "*"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The calculate method returns the correct result when multiplying large operands")
  public void multiplicationWithLargeOperands() {
    Assertions.assertEquals("72441 * 2048 = 148359168", new CalculatorConundrum().calculate(72_441, 2_048, "*"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The calculate method returns the correct result when dividing small operands")
  public void divisionWithSmallOperands() {
    Assertions.assertEquals("72 / 9 = 8", new CalculatorConundrum().calculate(72, 9, "/"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The calculate method returns the correct result when dividing large operands")
  public void divisionWithLargeOperands() {
    Assertions.assertEquals("1338800 / 83675 = 16", new CalculatorConundrum().calculate(1_338_800, 83_675, "/"));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The calculate method throws IllegalArgumentException when passing null operation")
  public void throwExceptionForNullAsOperation() {
    Assertions.assertEquals("Operation cannot be null", Assertions.assertThrows(IllegalArgumentException.class, () -> new CalculatorConundrum().calculate(66, 65, null)).getMessage());
  }

  @Test
  @Tag("task:2")
  @DisplayName("The calculate method throws IllegalArgumentException when passing empty operation")
  public void throwExceptionForAnEmptyStringOperation() {
    Assertions.assertEquals("Operation cannot be empty", Assertions.assertThrows(IllegalArgumentException.class, () -> new CalculatorConundrum().calculate(34, 324, "")).getMessage());
  }

  @Test
  @Tag("task:3")
  @DisplayName("The calculate method throws IllegalOperationException when dividing by zero")
  public void throwExceptionForDivisionByZero() {
    var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new CalculatorConundrum().calculate(33, 0, "/"));
    Assertions.assertEquals("Division by zero is not allowed", exception.getMessage());
  }

  @Test
  @Tag("task:4")
  @DisplayName("The calculate method returns the correct result when minus small operands")
  public void minusWithSmallOperands() {
    Assertions.assertEquals("4 - 1 = 3", new CalculatorConundrum().calculate(4, 1, "-"));
  }
}