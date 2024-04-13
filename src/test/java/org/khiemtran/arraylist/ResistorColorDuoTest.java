package org.khiemtran.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResistorColorDuoTest {
  private ResistorColorDuo resistorColorDuo;

  @BeforeEach
  public void setup() {
    resistorColorDuo = new ResistorColorDuo();
  }

  @Test
  public void testBrownAndBlack() {
    Assertions.assertEquals(10,
        resistorColorDuo.value(new String[]{"brown", "black"}));
  }

  @Test
  public void testBlueAndGrey() {
    assertThat(
        resistorColorDuo.value(new String[]{"blue", "grey"})
    ).isEqualTo(68);
  }

  @Test
  public void testOrangeAndOrange() {
    assertThat(resistorColorDuo.value(new String[]{"orange", "orange"})).isEqualTo(33);
  }

  @Test
  public void testWhiteAndRed() {
    assertThat(resistorColorDuo.value(new String[]{"white", "red"})).isEqualTo(92);
  }

  @Test
  public void testBlackAndBrownOneDigit() {
    assertThat(resistorColorDuo.value(new String[]{"black", "brown"})).isEqualTo(1);
  }

  @Test
  public void testIgnoreAdditionalColors() {
    assertThat(resistorColorDuo.value(new String[]{"green", "brown", "orange"})).isEqualTo(51);
  }
}