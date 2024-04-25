package org.khiemtran.recursion;

public class SumCalculator {
  public int sum(int number) {
    if (number < 1) {
      throw new IllegalArgumentException("number should be a positive.");
    }
    return number == 1 ? 1 : number + sum(number - 1);
  }
}
