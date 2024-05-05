package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsogramCheckerTest {
  private IsogramChecker isogramChecker = new IsogramChecker();

  @Test
  public void testEmptyString() {
    Assertions.assertTrue(isogramChecker.isIsogram(""));
  }

  @Test
  public void testLowercaseIsogram() {
    Assertions.assertTrue(isogramChecker.isIsogram("isogram"));
  }

  @Test
  public void testNotIsogram() {
    Assertions.assertFalse(isogramChecker.isIsogram("eleven"));
  }

  @Test
  public void testDuplicateEndAlphabet() {
    Assertions.assertFalse(isogramChecker.isIsogram("zzyzx"));
  }

  @Test
  public void testMediumLongIsogram() {
    Assertions.assertTrue(isogramChecker.isIsogram("subdermatoglyphic"));
  }

  @Test
  public void testCaseInsensitive() {
    Assertions.assertFalse(isogramChecker.isIsogram("Alphabet"));
  }

  @Test
  public void testDuplicateMixedCase() {
    Assertions.assertFalse(isogramChecker.isIsogram("alphAbet"));
  }

  @Test
  public void testIsogramWithHyphen() {
    Assertions.assertTrue(isogramChecker.isIsogram("thumbscrew-japingly"));
  }

  @Test
  public void testIsogramWithDuplicatedCharAfterHyphen() {
    Assertions.assertFalse(isogramChecker.isIsogram("thumbscrew-jappingly"));
  }

  @Test
  public void testIsogramWithDuplicatedHyphen() {
    Assertions.assertTrue(isogramChecker.isIsogram("six-year-old"));
  }

  @Test
  public void testMadeUpNameThatIsAnIsogram() {
    Assertions.assertTrue(isogramChecker.isIsogram("Emily Jung Schwartzkopf"));
  }

  @Test
  public void testDuplicatedCharacterInTheMiddleIsNotIsogram() {
    Assertions.assertFalse(isogramChecker.isIsogram("accentor"));
  }

  @Test
  public void testSameFirstAndLast() {
    Assertions.assertFalse(new IsogramChecker().isIsogram("angola"));
  }

  @Test
  public void testDuplicatedCharacterAndTwoHyphens() {
    Assertions.assertFalse(new IsogramChecker().isIsogram("up-to-date"));
  }
}