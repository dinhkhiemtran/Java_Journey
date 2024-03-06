package org.khiemtran;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  private Main main;
  @BeforeEach
  public void setup() {
    main = new Main();
  }
  @Test
  void getGreeting() {
    String greeting = "Hello, World!";
    Assertions.assertEquals(greeting, main.getGreeting());
  }
}