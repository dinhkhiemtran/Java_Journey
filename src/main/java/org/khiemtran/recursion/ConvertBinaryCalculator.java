package org.khiemtran.recursion;

public class ConvertBinaryCalculator {
  public int convertBinary(int number) {
    if (number < 1) {
      throw new IllegalArgumentException("number had batter be positive number");
    }
    if (number == 1) {
      return 1;
    } else {
      return (number % 2) + 10 * convertBinary(number / 2);
    }
  }
}
