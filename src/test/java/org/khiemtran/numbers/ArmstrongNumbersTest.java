package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArmstrongNumbersTest {
  private ArmstrongNumbers armstrongNumbers;

  @BeforeEach
  public void setup() {
    armstrongNumbers = new ArmstrongNumbers();
  }

  @Test
  public void zeroIsArmstrongNumber() {
    Assertions.assertTrue(armstrongNumbers.isArmstrongNumber(0));
  }

  @Test
  public void singleDigitsAreArmstrongNumbers() {
    Assertions.assertTrue(armstrongNumbers.isArmstrongNumber(5));
  }

  @Test
  public void noTwoDigitArmstrongNumbers() {
    Assertions.assertFalse(armstrongNumbers.isArmstrongNumber(10));
  }

  @Test
  public void threeDigitNumberIsArmstrongNumber() {
    Assertions.assertTrue(armstrongNumbers.isArmstrongNumber(153));
  }

  @Test
  public void threeDigitNumberIsNotArmstrongNumber() {
    Assertions.assertFalse(armstrongNumbers.isArmstrongNumber(100));
  }

  @Test
  public void fourDigitNumberIsArmstrongNumber() {
    Assertions.assertTrue(armstrongNumbers.isArmstrongNumber(9474));
  }

  @Test
  public void fourDigitNumberIsNotArmstrongNumber() {
    Assertions.assertFalse(armstrongNumbers.isArmstrongNumber(9475));
  }

  @Test
  public void sevenDigitNumberIsArmstrongNumber() {
    Assertions.assertTrue(armstrongNumbers.isArmstrongNumber(9926315));
  }

  @Test
  public void sevenDigitNumberIsNotArmstrongNumber() {
    Assertions.assertFalse(armstrongNumbers.isArmstrongNumber(9926314));
  }
}