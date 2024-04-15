package org.khiemtran.emuns.log_level;

public enum LogLevel {
  TRACE(1),
  DEBUG(2),
  INFO(4),
  WARNING(5),
  ERROR(6),
  FATAL(42),
  UNKNOWN(0);
  private int value;

  LogLevel(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
