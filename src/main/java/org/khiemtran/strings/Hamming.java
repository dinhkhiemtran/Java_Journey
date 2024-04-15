package org.khiemtran.strings;

import java.util.stream.Stream;

public class Hamming {
  private int distance;

  public Hamming(String leftStrand, String rightStrand) {
    if (leftStrand.length() != rightStrand.length()) {
      throw new IllegalArgumentException("strands must be of equal length");
    }
    this.distance = (int) Stream.iterate(0, i -> i + 1)
        .limit(leftStrand.length())
        .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
        .count();
  }

  public int getHammingDistance() {
    return distance;
  }
}
