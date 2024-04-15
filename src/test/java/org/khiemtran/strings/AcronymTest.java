package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AcronymTest {
  @Test
  public void basic() {
    Assertions.assertEquals("PNG",
        new Acronym("Portable Network Graphics").get());
  }

  @Test
  public void lowercaseWords() {
    Assertions.assertEquals("ROR",
        new Acronym("Ruby on Rails").get());
  }

  @Test
  public void punctuation() {
    Assertions.assertEquals("FIFO",
        new Acronym("First In, First Out").get());
  }

  @Test
  public void nonAcronymAllCapsWord() {
    Assertions.assertEquals("GIMP",
        new Acronym("GNU Image Manipulation Program").get());
  }

  @Test
  public void punctuationWithoutWhitespace() {
    Assertions.assertEquals("CMOS",
        new Acronym("Complementary metal-oxide semiconductor").get());
  }

  @Test
  public void veryLongAbbreviation() {
    Assertions.assertEquals("ROTFLSHTMDCOALM",
        new Acronym("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me").get());
  }

  @Test
  public void consecutiveDelimiters() {
    Assertions.assertEquals("SIMUFTA",
        new Acronym("Something - I made up from thin air").get());
  }

  @Test
  public void apostrophes() {
    Assertions.assertEquals("HC",
        new Acronym("Halley's Comet").get());
  }

  @Test
  public void underscoreEmphasis() {
    Assertions.assertEquals("TRNT",
        new Acronym("The Road _Not_ Taken").get());
  }
}