package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsbnVerifierTest {
  private IsbnVerifier isbnVerifier;

  @BeforeEach
  public void setUp() {
    isbnVerifier = new IsbnVerifier();
  }

  @Test
  public void validIsbnNumber() {
    System.out.println();
    Assertions.assertTrue(isbnVerifier.isValid("3-598-21508-8"));
  }

  @Test
  public void invalidIsbnCheckDigit() {
    Assertions.assertFalse(isbnVerifier.isValid("3-598-21508-9"));
  }

  @Test
  public void validIsbnNumberWithCheckDigitOfTen() {
    Assertions.assertTrue(isbnVerifier.isValid("3-598-21507-X"));
  }

  @Test
  public void validIsbnNumberWithCheckDigitPaddedWithLettersIsInvalid() {
    Assertions.assertFalse(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI"));
  }

  @Test
  public void checkDigitIsACharacterOtherThanX() {
    Assertions.assertFalse(isbnVerifier.isValid("3-598-21507-A"));
  }

  @Test
  public void invalidCheckDigitInIsbn() {
    Assertions.assertFalse(isbnVerifier.isValid("4-598-21507-B"));
  }

  @Test
  public void invalidCharacterInIsbn() {
    Assertions.assertFalse(isbnVerifier.isValid("3-598-P1581-X"));
  }

  @Test
  public void xIsOnlyValidAsACheckDigit() {
    Assertions.assertFalse(isbnVerifier.isValid("3-598-2X507-9"));
  }

  @Test
  public void validIsbnWithoutSeparatingDashes() {
    Assertions.assertTrue(isbnVerifier.isValid("3598215088"));
  }

  @Test
  public void isbnWithoutSeparatingDashesAndXAsCheckDigit() {
    Assertions.assertTrue(isbnVerifier.isValid("359821507X"));
  }

  @Test
  public void isbnWithoutCheckDigitAndDashes() {
    Assertions.assertFalse(isbnVerifier.isValid("359821507"));
  }

  @Test
  public void tooLongIsbnAndNoDashes() {
    Assertions.assertFalse(isbnVerifier.isValid("3598215078X"));
  }

  @Test
  public void tooShortIsbn() {
    Assertions.assertFalse(isbnVerifier.isValid("00"));
  }

  @Test
  public void isbnWithoutCheckDigit() {
    assertThat(isbnVerifier.isValid("3-598-21507")).isFalse();
  }

  @Test
  public void checkDigitOfXShouldNotBeUsedForZero() {
    assertThat(isbnVerifier.isValid("3-598-21515-X")).isFalse();
  }

  @Test
  public void emptyIsbn() {
    assertThat(isbnVerifier.isValid("")).isFalse();
  }

  @Test
  public void inputIsNineCharacters() {
    assertThat(isbnVerifier.isValid("134456729")).isFalse();
  }

  @Test
  public void invalidCharactersAreNotIgnoredAfterCheckingLength() {
    assertThat(isbnVerifier.isValid("3132P34035")).isFalse();
  }

  @Test
  public void invalidCharactersAreNotIgnoredBeforeCheckingLength() {
    assertThat(isbnVerifier.isValid("3598P215088")).isFalse();
  }

  @Test
  public void inputIsTooLongButContainsAValidIsbn() {
    assertThat(isbnVerifier.isValid("98245726788")).isFalse();
  }
}