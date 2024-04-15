package org.khiemtran.randoms.perfect_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NaturalNumberTest {
  @Test
  public void testSmallPerfectNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.PERFECT,
        new NaturalNumber(6).getClassification());
  }

  @Test
  public void testMediumPerfectNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.PERFECT,
        new NaturalNumber(28).getClassification());
  }

  @Test
  public void testLargePerfectNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.PERFECT,
        new NaturalNumber(33550336).getClassification());
  }

  @Test
  public void testSmallAbundantNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.ABUNDANT,
        new NaturalNumber(12).getClassification());
  }

  @Test
  public void testMediumAbundantNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.ABUNDANT,
        new NaturalNumber(30).getClassification());
  }

  @Test
  public void testLargeAbundantNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.ABUNDANT,
        new NaturalNumber(33550335).getClassification());
  }

  @Test
  public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.DEFICIENT,
        new NaturalNumber(2).getClassification());
  }

  @Test
  public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.DEFICIENT,
        new NaturalNumber(4).getClassification());
  }

  @Test
  public void testMediumDeficientNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.DEFICIENT,
        new NaturalNumber(32).getClassification());
  }

  @Test
  public void testLargeDeficientNumberIsClassifiedCorrectly() {
    Assertions.assertEquals(Classification.DEFICIENT,
        new NaturalNumber(33550337).getClassification());
  }

  @Test
  public void testThatOneIsCorrectlyClassifiedAsDeficient() {
    Assertions.assertEquals(Classification.DEFICIENT,
        new NaturalNumber(1).getClassification());
  }

  @Test
  public void testThatNonNegativeIntegerIsRejected() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new NaturalNumber(0));
    Assertions.assertEquals("You must supply a natural number (positive integer)",
        exception.getMessage());
  }

  @Test
  public void testThatNegativeIntegerIsRejected() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
        new NaturalNumber(-1));
    Assertions.assertEquals("You must supply a natural number (positive integer)",
        exception.getMessage());
  }
}