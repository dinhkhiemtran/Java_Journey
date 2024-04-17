package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SayTest {
  private Say say;

  @BeforeEach
  public void setup() {
    say = new Say();
  }

  @Test
  public void zero() {
    Assertions.assertEquals("zero",
        say.say(0));
  }

  @Test
  public void one() {
    Assertions.assertEquals("one", say.say(1));
  }

  @Test
  public void fourteen() {
    Assertions.assertEquals("fourteen",
        say.say(14));
  }

  @Test
  public void twenty() {
    Assertions.assertEquals("twenty",
        say.say(20));
  }

  @Test
  public void twentyTwo() {
    Assertions.assertEquals("twenty-two",
        say.say(22));
  }

  @Test
  public void thirty() {
    Assertions.assertEquals("thirty",
        say.say(30));
  }

  @Test
  public void ninetyNine() {
    Assertions.assertEquals("ninety-nine",
        say.say(99));
  }

  @Test
  public void oneHundred() {
    Assertions.assertEquals("one hundred",
        say.say(100));
  }

  @Test
  public void oneHundredTwentyThree() {
    Assertions.assertEquals("one hundred twenty-three",
        say.say(123));
  }

  @Test
  public void twoHundred() {
    Assertions.assertEquals("two hundred",
        say.say(200));
  }

  @Test
  public void nineHundredNinetyNine() {
    Assertions.assertEquals("nine hundred ninety-nine",
        say.say(999));
  }

  @Test
  public void oneThousand() {
    Assertions.assertEquals("one thousand",
        say.say(1_000));
  }

  @Test
  public void oneThousandTwoHundredThirtyFour() {
    Assertions.assertEquals("one thousand two hundred thirty-four",
        say.say(1_234));
  }

  @Test
  public void oneMillion() {
    Assertions.assertEquals("one million",
        say.say(1_000_000));
  }

  @Test
  public void oneMillionTwoThousandThreeHundredFortyFive() {
    Assertions.assertEquals("one million two thousand three hundred forty-five",
        say.say(1_002_345));
  }

  @Test
  public void oneBillion() {
    Assertions.assertEquals("one billion",
        say.say(1_000_000_000));
  }

  @Test
  public void nineHundredEightySevenBillionSixHundredFiftyFourThreeHundredTwentyOneThousandOneHundredTwentyThree() {
    Assertions.assertEquals("nine hundred eighty-seven billion six hundred fifty-four million" +
            " three hundred twenty-one thousand one hundred twenty-three",
        say.say(987_654_321_123L));
  }

  @Test
  public void illegalNegativeNumber() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> say.say(-1));
  }

  @Test
  public void illegalTooBigNumber() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> say.say(1_000_000_000_000L));
  }
}