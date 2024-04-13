package org.khiemtran.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
  private static final long GIGASECOND = 1000000000l;
  private LocalDateTime moment;

  public Gigasecond(LocalDate moment) {
    this.moment = moment.atStartOfDay();
  }

  public Gigasecond(LocalDateTime moment) {
    this.moment = moment;
  }

  public LocalDateTime getDateTime() {
    return moment.plusSeconds(GIGASECOND);
  }
}
