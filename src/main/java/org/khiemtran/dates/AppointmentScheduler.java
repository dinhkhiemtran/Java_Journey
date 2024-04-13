package org.khiemtran.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class AppointmentScheduler {
  public LocalDateTime schedule(String appointmentDateDescription) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    return LocalDateTime.parse(appointmentDateDescription, dateTimeFormatter);
  }

  public boolean hasPassed(LocalDateTime appointmentDate) {
    return LocalDateTime.now().isAfter(appointmentDate);
  }

  public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
    return appointmentDate.getHour() > 11 && appointmentDate.getHour() < 18;
  }

  public String getDescription(LocalDateTime appointmentDate) {
    return String.format("You have an appointment on %s, %s %s, %s, at %s.",
        appointmentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
        appointmentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
        appointmentDate.getDayOfMonth(),
        appointmentDate.getYear(),
        appointmentDate.format(DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH)));
  }

  public LocalDate getAnniversaryDate() {
    return LocalDate.of(2024, 9, 15);
  }
}
