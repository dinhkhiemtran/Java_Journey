package org.khiemtran.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialCalculatorTest {
  private FactorialCalculator factorialCalculator;

  @BeforeEach
  public void setup() {
    factorialCalculator = new FactorialCalculator();
  }

  @Test
  public void testFactorial() {
    Assertions.assertEquals(120, factorialCalculator.factorial(5));
  }

  @Test
  public void testFactorialZero() {
    Assertions.assertEquals(1, factorialCalculator.factorial(0));
  }

  @Test
  public void testFactorialOne() {
    Assertions.assertEquals(1, factorialCalculator.factorial(1));
  }
}