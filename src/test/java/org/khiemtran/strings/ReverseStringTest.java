package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.strings.ReverseString;

class ReverseStringTest {
  @Test
  public void reverseString() {
    Assertions.assertEquals("desserts",
        new ReverseString().reverse("stressed"));
  }

  @Test
  public void testAnEmptyString() {
    Assertions.assertEquals("",
        new ReverseString().reverse(""));
  }

  @Test
  public void testAWord() {
    Assertions.assertEquals("tobor",
        new ReverseString().reverse("robot"));
  }

  @Test
  public void testACapitalizedWord() {
    Assertions.assertEquals("nemaR",
        new ReverseString().reverse("Ramen"));
  }

  @Test
  public void testASentenceWithPunctuation() {
    Assertions.assertEquals("!yrgnuh m'I",
        new ReverseString().reverse("I'm hungry!"));
  }

  @Test
  public void testAPalindrome() {
    Assertions.assertEquals("racecar",
        new ReverseString().reverse("racecar"));
  }

  @Test
  public void testAnEvenSizedWord() {
    Assertions.assertEquals("reward", new ReverseString().reverse("drawer"));
  }
}