package org.khiemtran.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.khiemtran.recursion.CollatzCalculator;

class CollatzCalculatorTest {
  private CollatzCalculator collatzCalculator;

  @BeforeEach
  public void setup() {
    collatzCalculator = new CollatzCalculator();
  }

  @Test
  public void testZeroStepsRequiredWhenStartingFrom1() {
    Assertions.assertEquals(0, collatzCalculator.computeStepCount(1));
  }

  @Test
  public void testCorrectNumberOfStepsWhenAllStepsAreDivisions() {
    Assertions.assertEquals(4, collatzCalculator.computeStepCount(16));
  }

  @Test
  public void testCorrectNumberOfStepsWhenBothStepTypesAreNeeded() {
    Assertions.assertEquals(9,
        collatzCalculator.computeStepCount(12));
  }

  @Test
  public void testAVeryLargeInput() {
    Assertions.assertEquals(152,
        collatzCalculator.computeStepCount(1000000));
  }

  @Test
  public void testZeroIsConsideredInvalidInput() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> collatzCalculator.computeStepCount(0),
        "Only positive integers are allowed");
  }

  @Test
  public void testNegativeIntegerIsConsideredInvalidInput() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> collatzCalculator.computeStepCount(-16),
        "Only positive integers are allowed");
  }
}