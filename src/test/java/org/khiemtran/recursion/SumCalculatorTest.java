package org.khiemtran.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {
  private SumCalculator sumCalculator;

  @BeforeEach
  public void setup() {
    sumCalculator = new SumCalculator();
  }

  @Test
  public void testSumOne() {
    Assertions.assertEquals(1, sumCalculator.sum(1));
  }

  @Test
  public void testSumZero() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(0),
        "number should be a positive.");
  }

  @Test
  public void testSumFive() {
    Assertions.assertEquals(15,
        sumCalculator.sum(5));
  }
}