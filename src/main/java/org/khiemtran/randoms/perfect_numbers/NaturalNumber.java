package org.khiemtran.randoms.perfect_numbers;

import java.util.stream.IntStream;

public class NaturalNumber {
  private int number;

  NaturalNumber(int number) {
    if (number < 1) {
      throw new IllegalArgumentException("You must supply a natural number (positive integer)");
    }
    this.number = number;
  }

  Classification getClassification() {
    int sum = getSum();
    if (sum < this.number) return Classification.DEFICIENT;
    if (sum > this.number) return Classification.ABUNDANT;
    return Classification.PERFECT;
  }

  private int getSum() {
    return IntStream.range(1, number)
        .filter(i -> number % i == 0)
        .sum();
  }
}
