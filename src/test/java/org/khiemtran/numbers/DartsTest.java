package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DartsTest {
  Darts darts = new Darts();

  @Test
  public void missedTarget() {
    int actual = darts.score(-9, 9);
    Assertions.assertEquals(0, actual);
  }

  @Test
  public void onTheOuterCircle() {
    int actual = darts.score(0, 10);
    Assertions.assertEquals(1, actual);
  }

  @Test
  public void onTheMiddleCircle() {
    int actual = darts.score(-5, 0);
    Assertions.assertEquals(5, actual);
  }

  @Test
  public void onTheInnerCircle() {
    int actual = darts.score(0, -1);
    Assertions.assertEquals(10, actual);
  }

  @Test
  public void exactlyOnCentre() {
    int actual = darts.score(0, 0);
    Assertions.assertEquals(10, actual);
  }

  @Test
  public void nearTheCentre() {
    int actual = darts.score(-0.1, -0.1);
    Assertions.assertEquals(10, actual);
  }

  @Test
  public void justWithinTheInnerCircle() {
    int actual = darts.score(0.7, 0.7);
    Assertions.assertEquals(10, actual);
  }

  @Test
  public void justOutsideTheInnerCircle() {
    int actual = darts.score(0.8, -0.8);
    Assertions.assertEquals(5, actual);
  }

  @Test
  public void justWithinTheMiddleCircle() {
    int actual = darts.score(-3.5, 3.5);
    Assertions.assertEquals(5, actual);
  }

  @Test
  public void justOutsideTheMiddleCircle() {
    int actual = darts.score(-3.6, -3.6);
    Assertions.assertEquals(1, actual);
  }

  @Test
  public void justWithinTheOuterCircle() {
    int actual = darts.score(-7.0, 7.0);
    Assertions.assertEquals(1, actual);
  }

  @Test
  public void justOutsideTheOuterCircle() {
    int actual = darts.score(7.1, -7.1);
    System.out.println(actual);
    Assertions.assertEquals(0, actual);
  }

  @Test
  public void asymmetricPositionBetweenTheInnerAndMiddleCircles() {
    Assertions.assertEquals(5, darts.score(0.5, -4));
  }
}