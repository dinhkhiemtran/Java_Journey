package org.khiemtran;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {
  @Test
  public void testGreeting() {
    Assertions.assertEquals("Hello World",
        new Main().greeting());
  }
}