package org.khiemtran.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoferTest {
  private Twofer twofer;

  @BeforeEach
  public void setup() {
    twofer = new Twofer();
  }

  @Test
  public void noNameGiven() {
    Assertions.assertEquals("One for you, one for me.", twofer.twofer(null));
  }

  @Test
  public void aNameGiven() {
    Assertions.assertEquals("One for Alice, one for me.", twofer.twofer("Alice"));
  }

  @Test
  public void anotherNameGiven() {
    Assertions.assertEquals("One for Bob, one for me.", twofer.twofer("Bob"));
  }
}