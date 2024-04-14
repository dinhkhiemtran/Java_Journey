package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.strings.FootballMatchReports;

class FootballMatchReportsTest {
  @Test
  public void testOnFiled() {
    Assertions.assertEquals("striker", new FootballMatchReports().onField(10));
  }

  @Test
  public void testGoalieOnFiled() {
    Assertions.assertEquals("goalie", new FootballMatchReports().onField(1));
  }

  @Test
  public void testIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new FootballMatchReports().onField(13));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of player with shirt number 2")
  public void test_left_back() {
    Assertions.assertEquals("left back", FootballMatchReports.onField(2));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of player with shirt number 5")
  public void test_right_back() {
    Assertions.assertEquals("right back", FootballMatchReports.onField(5));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of players with shirt numbers 3 and 4")
  public void test_center_back() {
    Assertions.assertEquals("center back", FootballMatchReports.onField(4));
    Assertions.assertEquals("center back", FootballMatchReports.onField(3));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of players with shirt numbers 6, 7 and 8")
  public void test_midfielder() {
    Assertions.assertEquals("midfielder", FootballMatchReports.onField(8));
    Assertions.assertEquals("midfielder", FootballMatchReports.onField(7));
    Assertions.assertEquals("midfielder", FootballMatchReports.onField(6));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of player with shirt number 9")
  public void test_left_wing() {
    Assertions.assertEquals("left wing", FootballMatchReports.onField(9));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of player with shirt number 10")
  public void test_striker() {
    Assertions.assertEquals("striker", FootballMatchReports.onField(10));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The onField method returns the correct description of player with shirt number 11")
  public void test_right_wing() {
    Assertions.assertEquals("right wing", FootballMatchReports.onField(11));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The onField method throws IllegalArgumentException for unknown shirt number")
  public void test_exception() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new FootballMatchReports().onField(13));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The onField method throws IllegalArgumentException for negative shirt number")
  public void test_exception_negative_number() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new FootballMatchReports().onField(-1));
  }
}