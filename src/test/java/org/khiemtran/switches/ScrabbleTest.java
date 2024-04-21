package org.khiemtran.switches;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScrabbleTest {
  @Test
  public void testALowerCaseLetter() {
    Assertions.assertEquals(1,
        new Scrabble("a").getScore());
  }

  @Test
  public void testAUpperCaseLetter() {
    Scrabble scrabble = new Scrabble("A");
    Assertions.assertEquals(1, scrabble.getScore());
  }

  @Test
  public void testAValuableLetter() {
    Scrabble scrabble = new Scrabble("f");
    Assertions.assertEquals(4, scrabble.getScore());
  }

  @Test
  public void testAShortWord() {
    Scrabble scrabble = new Scrabble("at");
    Assertions.assertEquals(2,
        scrabble.getScore());
  }

  @Test
  public void testAShortValuableWord() {
    Scrabble scrabble = new Scrabble("zoo");
    Assertions.assertEquals(12,
        scrabble.getScore());
  }

  @Test
  public void testAMediumWord() {
    Scrabble scrabble = new Scrabble("street");
    Assertions.assertEquals(6,
        scrabble.getScore());
  }

  @Test
  public void testAMediumValuableWord() {
    Scrabble scrabble = new Scrabble("quirky");
    Assertions.assertEquals(22, scrabble.getScore());
  }

  @Test
  public void testALongMixCaseWord() {
    Scrabble scrabble = new Scrabble("OxyphenButazone");
    Assertions.assertEquals(41, scrabble.getScore());
  }

  @Test
  public void testAEnglishLikeWord() {
    Assertions.assertEquals(8,
        new Scrabble("pinata").getScore());
  }

  @Test
  public void testAnEmptyInput() {
    Assertions.assertEquals(0,
        new Scrabble("").getScore());
  }

  @Test
  public void testEntireAlphabetAvailable() {
    Assertions.assertEquals(87,
        new Scrabble("abcdefghijklmnopqrstuvwxyz").getScore());
  }
}