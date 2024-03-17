package org.khiemtran.basics.log_level;

import java.util.HashMap;
import java.util.Map;

public class LogLine {
  private static Map<String, LogLevel> LOGS = new HashMap<>();
  private String logLine;

  static {
    LOGS.put("INF", LogLevel.INFO);
    LOGS.put("DBG", LogLevel.DEBUG);
    LOGS.put("TRC", LogLevel.TRACE);
    LOGS.put("WRN", LogLevel.WARNING);
    LOGS.put("ERR", LogLevel.ERROR);
    LOGS.put("FTL", LogLevel.FATAL);
  }

  public LogLine(String logLine) {
    this.logLine = logLine;
  }

  public LogLevel getLogLevel() {
    String log = logLine.substring(logLine.indexOf('[') + 1, logLine.indexOf(']'));
    return LOGS.getOrDefault(log, LogLevel.UNKNOWN);
  }

  public String getOutputForShortLog() {
    return String.format("%d:%s", getLogLevel().getValue(), logLine.substring(logLine.indexOf(':') + 2));
  }
}
