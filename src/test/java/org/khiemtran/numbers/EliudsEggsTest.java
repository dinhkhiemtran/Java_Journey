package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EliudsEggsTest {
  @Test
  @DisplayName("0 eggs")
  public void test0Eggs() {
    Assertions.assertEquals(0,
        new EliudsEggs().eggCount(0));
  }

  @Test
  @DisplayName("1 egg")
  public void test1Egg() {
    Assertions.assertEquals(1,
        new EliudsEggs().eggCount(16));
  }

  @Test
  @DisplayName("4 eggs")
  public void test4Eggs() {
    Assertions.assertEquals(4,
        new EliudsEggs().eggCount(89));
  }

  @Test
  @DisplayName("13 eggs")
  public void test13Eggs() {
    Assertions.assertEquals(13,
        new EliudsEggs().eggCount(2000000000));
  }
}