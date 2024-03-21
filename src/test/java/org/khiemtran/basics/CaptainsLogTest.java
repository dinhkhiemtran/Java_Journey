package org.khiemtran.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class CaptainsLogTest {
  private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

  @Test
  public void testPlanets() {
    boolean isCorrect = false;
    for (int i = 0; i < PLANET_CLASSES.length; i++) {
      if (new CaptainsLog(new Random()).randomPlanetClass() == PLANET_CLASSES[i]) {
        System.out.println(PLANET_CLASSES[i]);
        isCorrect = true;
        break;
      }
    }
    Assertions.assertTrue(isCorrect);
  }
}