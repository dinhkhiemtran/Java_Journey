package org.khiemtran.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConvertBinaryCalculatorTest {
  private ConvertBinaryCalculator convertBinaryCalculator;

  @BeforeEach
  public void setup() {
    convertBinaryCalculator = new ConvertBinaryCalculator();
  }

  @Test
  public void testConvertBinaryOne() {
    Assertions.assertEquals(1, convertBinaryCalculator.convertBinary(1));
  }

  @Test
  public void testConvertBinary() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> convertBinaryCalculator.convertBinary(-1),
        "number should be a positive.");
  }

  @Test
  public void testConvertBinaryFive() {
    Assertions.assertEquals(101,
        convertBinaryCalculator.convertBinary(5));
  }
}