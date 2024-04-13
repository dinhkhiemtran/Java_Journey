package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HammingTest {
  @Test
  public void testNoDistanceBetweenEmptyStrands() {
    Assertions.assertEquals(0,
        new Hamming("", "").getHammingDistance());
  }

  @Test
  public void testNoDistanceBetweenShortIdenticalStrands() {
    Assertions.assertEquals(0,
        new Hamming("A", "A").getHammingDistance());
  }

  @Test
  public void testCompleteDistanceInSingleLetterDifferentStrands() {
    Assertions.assertEquals(1,
        new Hamming("G", "T").getHammingDistance());
  }

  @Test
  public void testDistanceInLongIdenticalStrands() {
    Assertions.assertEquals(0,
        new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance());
  }

  @Test
  public void testDistanceInLongDifferentStrands() {
    Assertions.assertEquals(9,
        new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
  }

  @Test
  public void testValidatesFirstStrandNotLonger() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Hamming("AATG", "AAA"));
    Assertions.assertEquals("strands must be of equal length", exception.getMessage());
  }

  @Test
  public void testValidatesSecondStrandNotLonger() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Hamming("ATA", "AGTG"));
    Assertions.assertEquals("strands must be of equal length", exception.getMessage());
  }

  @Test
  public void testDisallowLeftEmptyStrand() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Hamming("", "G"));
    Assertions.assertEquals("strands must be of equal length",
        exception.getMessage());
  }

  @Test
  public void testDisallowRightEmptyStrand() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Hamming("G", ""));
    Assertions.assertEquals("strands must be of equal length",
        exception.getMessage());
  }
}