package org.khiemtran.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SecretsTest {
  @Test
  public void testShiftBack() {
    Assertions.assertEquals(0b0010,
        Secrets.shiftBack(0b1001, 2));
  }

  @Test
  public void testSetBit() {
    int expect = 0b0111;
    Assertions.assertEquals(expect, Secrets.setBits(0b0110, 0b0101));
  }

  @Test
  public void testFlipBits() {
    int expect = 0b1001;
    Assertions.assertEquals(expect,
        Secrets.flipBits(0b1100, 0b0101));
  }

  @Test
  @Tag("task:1")
  @DisplayName("shift 8 back 2 places")
  public void shift8Back2Places() {
    Assertions.assertEquals(2, Secrets.shiftBack(8, 2));
  }

  @Test
  @Tag("task:2")
  @DisplayName("set bits in 5")
  public void setBitsIn5() {
    Assertions.assertEquals(7,
        Secrets.setBits(5, 3));
  }

  @Test
  @Tag("task:2")
  @DisplayName("set bits in 5_652")
  public void setBitsIn5652() {
    Assertions.assertEquals(30_262,
        Secrets.setBits(5_652, 26_150));
  }

  @Test
  @Tag("task:3")
  @DisplayName("flip bits in 5")
  public void flipBitsIn5() {
    Assertions.assertEquals(14,
        Secrets.flipBits(5, 11));
  }

  @Test
  @Tag("task:3")
  @DisplayName("flip bits in 38_460")
  public void flipBitsIn38460() {
    Assertions.assertEquals(43_603, Secrets.flipBits(38_460, 15_471));
  }

  @Test
  @Tag("task:4")
  @DisplayName("clear bits from 5")
  public void clearBitsFrom5() {
    Assertions.assertEquals(4, Secrets.clearBits(5, 11));
  }

  @Test
  @Tag("task:4")
  @DisplayName("clear bits from 90")
  public void clearBitsFrom90() {
    Assertions.assertEquals(10, Secrets.clearBits(90, 240));
  }

  @Test
  public void testClearBits() {
    int expect = 0b0010;
    Assertions.assertEquals(expect,
        Secrets.clearBits(0b0110, 0b0101));
  }

  @Test
  @Tag("task:1")
  @DisplayName("shift -2_144_333_657 back 3 places")
  public void shiftNegativeNumberBack3Places() {
    Assertions.assertEquals(268_829_204,
        Secrets.shiftBack(-2_144_333_657, 3));
  }
}