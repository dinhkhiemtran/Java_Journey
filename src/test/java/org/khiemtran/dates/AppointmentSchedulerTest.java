package org.khiemtran.dates;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class AppointmentSchedulerTest {
  private AppointmentScheduler scheduler;

  @BeforeEach
  public void setup() {
    scheduler = new AppointmentScheduler();
  }

  @Test
  public void testSchedule() {
    Assertions.assertEquals(LocalDateTime.of(2019, 7, 25, 13, 45, 0),
        new AppointmentScheduler().schedule("07/25/2019 13:45:00"));
  }

  @Test
  public void testGetDescription() {
    Assertions.assertEquals("You have an appointment on Friday, March 29, 2019, at 3:00 PM.",
        new AppointmentScheduler().getDescription(
            LocalDateTime.of(2019, 3, 29, 15, 0, 0)));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Noon appointment is an afternoon appointment")
  public void testIsAfternoonAppointmentForNoonAppointment() {
    var appointment = LocalDateTime.of(2019, 8, 9, 12, 0, 0);
    Assertions.assertTrue(new AppointmentScheduler().hasPassed(appointment));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Early afternoon appointment is an afternoon appointment")
  public void testIsAfternoonAppointmentForEarlyAfternoonAppointment() {
    var appointment = LocalDateTime.of(2019, 8, 9, 12, 0, 1);
    assertThat(new AppointmentScheduler().isAfternoonAppointment(appointment)).isTrue();
  }

  @Test
  @Tag("task:5")
  @DisplayName("The anniversary date")
  public void testAnniversaryDate() {
    var expected = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    Assertions.assertEquals(expected, new AppointmentScheduler().getAnniversaryDate());
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment from one year ago has passed")
  public void testHasPassedOneYearAgo() {
    var oneYearAgo = LocalDateTime.now().minusYears(1).plusHours(2);
    Assertions.assertTrue(scheduler.hasPassed(oneYearAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment from months ago has passed")
  public void testHasPassedMonthsAgo() {
    var monthsAgo = LocalDateTime.now().minusMonths(8);
    Assertions.assertTrue(scheduler.hasPassed(monthsAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment from days ago has passed")
  public void testHasPassedDaysAgo() {
    var daysAgo = LocalDateTime.now().minusDays(23);
    Assertions.assertTrue(scheduler.hasPassed(daysAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment from hours ago has passed")
  public void testHasPassedHoursAgo() {
    var hoursAgo = LocalDateTime.now().minusHours(12);
    Assertions.assertTrue(scheduler.hasPassed(hoursAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment from minutes ago has passed")
  public void testHasPassedMinutesAgo() {
    var minutesAgo = LocalDateTime.now().minusMinutes(55);
    Assertions.assertTrue(scheduler.hasPassed(minutesAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment from one minute ago has passed")
  public void testHasPassedOneMinuteAgo() {
    var oneMinuteAgo = LocalDateTime.now().minusMinutes(1);
    Assertions.assertTrue(scheduler.hasPassed(oneMinuteAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment minutes from now has not passed")
  public void testHasPassedMinutesFromNow() {
    var minutesAgo = LocalDateTime.now().plusMinutes(5);
    Assertions.assertFalse(scheduler.hasPassed(minutesAgo));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment hours from now has not passed")
  public void testHasPassedHoursFromNow() {
    var hoursFromNow = LocalDateTime.now().plusHours(3);
    Assertions.assertFalse(scheduler.hasPassed(hoursFromNow));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment days from now has not passed")
  public void testHasPassedDaysFromNow() {
    var daysFromNow = LocalDateTime.now().plusDays(19);
    Assertions.assertFalse(scheduler.hasPassed(daysFromNow));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment months from now has not passed")
  public void testHasPassedMonthsFromNow() {
    var monthsFromNow = LocalDateTime.now().plusMonths(10);
    Assertions.assertFalse(scheduler.hasPassed(monthsFromNow));
  }

  @Test
  @Tag("task:2")
  @DisplayName("Appointment years from now has not passed")
  public void testHasPassedYearsFromNow() {
    var yearsFromNow = LocalDateTime.now().plusYears(2).plusMonths(3).plusDays(6);
    Assertions.assertFalse(scheduler.hasPassed(yearsFromNow));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Early morning appointment is not an afternoon appointment")
  public void testIsAfternoonAppointmentForEarlyMorningAppointment() {
    var appointment = LocalDateTime.of(2019, 6, 17, 8, 15, 0);
    Assertions.assertFalse(scheduler.isAfternoonAppointment(appointment));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Late morning appointment is not an afternoon appointment")
  public void testIsAfternoonAppointmentForLateMorningAppointment() {
    var appointment = LocalDateTime.of(2019, 2, 23, 11, 59, 59);
    Assertions.assertFalse(scheduler.isAfternoonAppointment(appointment));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Late morning appointment is an afternoon appointment")
  public void testIsAfternoonAppointmentForLateAfternoonAppointment() {
    var appointment = LocalDateTime.of(2019, 9, 1, 17, 59, 59);
    Assertions.assertTrue(scheduler.isAfternoonAppointment(appointment));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Early evening appointment is not an afternoon appointment")
  public void testIsAfternoonAppointmentForEarlyEveningAppointment() {
    var appointment = LocalDateTime.of(2019, 9, 1, 18, 0, 0);
    Assertions.assertFalse(scheduler.isAfternoonAppointment(appointment));
  }

  @Test
  @Tag("task:3")
  @DisplayName("Late evening appointment is not an afternoon appointment")
  public void testIsAfternoonAppointmentForLateEveningAppointment() {
    var appointment = LocalDateTime.of(2019, 9, 1, 23, 59, 59);
    Assertions.assertFalse(scheduler.isAfternoonAppointment(appointment));
  }

  @Test
  @Tag("task:4")
  @DisplayName("Description on Friday afternoon")
  public void testDescriptionOnFridayAfternoon() {
    var appointment = LocalDateTime.of(2019, 3, 29, 15, 0, 0);
    var expected = "You have an appointment on Friday, March 29, 2019, at 3:00 PM.";
    Assertions.assertEquals(expected, scheduler.getDescription(appointment));
  }

  @Test
  @Tag("task:4")
  @DisplayName("Description on Thursday afternoon")
  public void testDescriptionOnThursdayAfternoon() {
    var appointment = LocalDateTime.of(2019, 7, 25, 13, 45, 0);
    var expected = "You have an appointment on Thursday, July 25, 2019, at 1:45 PM.";
    Assertions.assertEquals(expected, scheduler.getDescription(appointment));
  }

  @Test
  @Tag("task:4")
  @DisplayName("Description on Wednesday morning")
  public void testDescriptionOnWednesdayMorning() {
    var appointment = LocalDateTime.of(2020, 9, 9, 9, 9, 9);
    var expected = "You have an appointment on Wednesday, September 9, 2020, at 9:09 AM.";
    Assertions.assertEquals(expected, scheduler.getDescription(appointment));
  }
}