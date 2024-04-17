package org.khiemtran.maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RaindropConverterTest {
  private final RaindropConverter raindropConverter = new RaindropConverter();

  @Test
  public void soundFor1Is1() {
    Assertions.assertEquals("1",
        raindropConverter.convert(1));
  }

  @Test
  public void soundFor3IsPling() {
    Assertions.assertEquals("Pling",
        raindropConverter.convert(3));
  }

  @Test
  public void soundFor5IsPlang() {
    Assertions.assertEquals("Plang",
        raindropConverter.convert(5));
  }

  @Test
  public void soundFor7IsPlong() {
    Assertions.assertEquals("Plong",
        raindropConverter.convert(7));
  }

  @Test
  public void soundFor6IsPlingAsItHasFactor3() {
    Assertions.assertEquals("Pling",
        raindropConverter.convert(6));
  }

  @Test
  public void noSoundFor2Cubed() {
    Assertions.assertEquals("8",
        raindropConverter.convert(8));
  }

  @Test
  public void soundFor9IsPlingAsItHasFactor3() {
    Assertions.assertEquals("Pling",
        raindropConverter.convert(9));
  }

  @Test
  public void soundFor10IsPlangAsItHasFactor5() {
    Assertions.assertEquals("Plang",
        raindropConverter.convert(10));
  }

  @Test
  public void soundFor14IsPlongAsItHasFactor7() {
    Assertions.assertEquals("Plong",
        raindropConverter.convert(14));
  }

  @Test
  public void soundFor15IsPlingPlangAsItHasFactors3And5() {
    Assertions.assertEquals("PlingPlang",
        raindropConverter.convert(15));
  }

  @Test
  public void soundFor21IsPlingPlongAsItHasFactors3And7() {
    Assertions.assertEquals("PlingPlong",
        raindropConverter.convert(21));
  }

  @Test
  public void soundFor25IsPlangAsItHasFactor5() {
    Assertions.assertEquals("Plang",
        raindropConverter.convert(25));
  }

  @Test
  public void soundFor27IsPlingAsItHasFactor3() {
    Assertions.assertEquals("Pling",
        raindropConverter.convert(27));
  }

  @Test
  public void soundFor35IsPlangPlongAsItHasFactors5And7() {
    Assertions.assertEquals("PlangPlong",
        raindropConverter.convert(35));
  }

  @Test
  public void soundFor49IsPlongAsItHasFactor7() {
    Assertions.assertEquals("Plong",
        raindropConverter.convert(49));
  }

  @Test
  public void noSoundFor52() {
    Assertions.assertEquals("52",
        raindropConverter.convert(52));
  }

  @Test
  public void soundFor105IsPlingPlangPlongAsItHasFactors3And5And7() {
    Assertions.assertEquals("PlingPlangPlong",
        raindropConverter.convert(105));
  }

  @Test
  public void soundFor3125IsPlangAsItHasFactor5() {
    Assertions.assertEquals(
        "Plang", raindropConverter.convert(3125));
  }
}