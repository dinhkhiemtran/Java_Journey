package org.khiemtran.randoms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.randoms.CaptainsLog;

import java.util.Random;
import java.util.stream.Stream;

class CaptainsLogTest {
  private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

  @Test
  public void testPlanets() {
    char valueOfRandomPlanetClass = new CaptainsLog(new Random()).randomPlanetClass();
    boolean isCorrect = Stream.iterate(0, i -> i + 1)
        .limit(PLANET_CLASSES.length)
        .anyMatch(i -> PLANET_CLASSES[i] == valueOfRandomPlanetClass);
    Assertions.assertTrue(isCorrect);
  }
}