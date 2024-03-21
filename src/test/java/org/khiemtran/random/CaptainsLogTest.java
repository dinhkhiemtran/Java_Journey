package org.khiemtran.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

class CaptainsLogTest {
  private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

  @Test
  public void testPlanets() {
    char random = new CaptainsLog(new Random()).randomPlanetClass();
    boolean isPresent = IntStream.range(0, PLANET_CLASSES.length)
        .mapToObj(i -> PLANET_CLASSES[i])
        .anyMatch(ch -> ch == random);
    Assertions.assertTrue(isPresent);
  }
}