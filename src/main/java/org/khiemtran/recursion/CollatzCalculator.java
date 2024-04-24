package org.khiemtran.recursion;

public class CollatzCalculator {
  int computeStepCount(int start) {
    if (start < 1) {
      throw new IllegalArgumentException("Only positive integers are allowed");
    }
    if (start == 1) {
      return 0;
    }
    return start % 2 == 0 ? computeStepCount(start / 2) + 1
        : computeStepCount(3 * start + 1) + 1;
  }
}
