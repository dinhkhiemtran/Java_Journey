package org.khiemtran.booleans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PangramCheckerTest {
  private PangramChecker pangramChecker;

  @BeforeEach
  public void setup() {
    pangramChecker = new PangramChecker();
  }

  @Test
  public void emptySentenceIsNotPangram() {
    Assertions.assertFalse(pangramChecker.isPangram(""));
  }

  @Test
  public void perfectLowerCasePhraseIsPangram() {
    Assertions.assertTrue(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz"));
  }

  @Test
  public void phraseWithOnlyLowerCaseIsPangram() {
    Assertions.assertTrue(pangramChecker.isPangram("the quick brown fox jumps over the lazy dog"));
  }

  @Test
  public void phraseMissingCharacterXIsNotPangram() {
    Assertions.assertFalse(pangramChecker.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
  }

  @Test
  public void phraseMissingCharacterHIsNotPangram() {
    Assertions.assertFalse(pangramChecker.isPangram("five boxing wizards jump quickly at it"));
  }

  @Test
  public void phraseWithUnderscoresIsPangram() {
    Assertions.assertTrue(pangramChecker.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"));
  }

  @Test
  public void phraseWithNumbersIsPangram() {
    Assertions.assertTrue(pangramChecker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
  }

  @Test
  public void phraseWithMissingLettersReplacedByNumbersIsNotPangram() {
    Assertions.assertFalse(pangramChecker.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"));
  }

  @Test
  public void phraseWithMixedCaseAndPunctuationIsPangram() {
    Assertions.assertTrue(pangramChecker.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
  }

  @Test
  public void caseInsensitivePhraseIsNotPangram() {
    Assertions.assertFalse(pangramChecker.isPangram("abcdefghijklm ABCDEFGHIJKLM"));
  }
}