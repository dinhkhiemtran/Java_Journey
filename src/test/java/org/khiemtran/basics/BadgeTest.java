package org.khiemtran.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BadgeTest {
  @Test
  public void testEmployeeBadgeLabel() {
    Assertions.assertEquals("[734] - Ernest Johnny Payne - STRATEGIC COMMUNICATION",
        new Badge().print(734, "Ernest Johnny Payne", "Strategic Communication"));
  }

  @Test
  public void testEmployeeDoNotYetHaveID() {
    Assertions.assertEquals("Jane Johnson - PROCUREMENT",
        new Badge().print(null, "Jane Johnson", "Procurement"));
  }

  @Test
  public void test() {
    Assertions.assertEquals("[254] - Charlotte Hale - OWNER",
        new Badge().print(254, "Charlotte Hale", null));
  }

  @Test
  public void testTask3() {
    Assertions.assertEquals("Charlotte Hale - OWNER",
        new Badge().print(null, "Charlotte Hale", null));
  }

  @Test
  @Tag("task:1")
  @DisplayName("Printing a badge for an employee")
  public void labelForEmployee() {
    Badge badge = new Badge();
    Assertions.assertEquals("[17] - Ryder Herbert - MARKETING", badge.print(17, "Ryder Herbert", "Marketing"));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Printing a badge for a new employee")
  public void labelForNewEmployee() {
    Badge badge = new Badge();
    Assertions.assertEquals("Bogdan Rosario - MARKETING", badge.print(null, "Bogdan Rosario", "Marketing"));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Printing a badge for the owner")
  public void labelForOwner() {
    Badge badge = new Badge();
    Assertions.assertEquals("[59] - Julie Sokato - OWNER", badge.print(59, "Julie Sokato", null));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Printing a badge for the owner who is a new employee")
  public void labelForNewOwner() {
    Badge badge = new Badge();
    Assertions.assertEquals("Amare Osei - OWNER", badge.print(null, "Amare Osei", null));
  }
}