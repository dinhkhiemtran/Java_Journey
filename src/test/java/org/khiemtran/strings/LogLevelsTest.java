package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.strings.LogLevels;

class LogLevelsTest {
  @Test
  public void testMessage() {
    Assertions.assertEquals("Invalid operation", LogLevels.message("[ERROR]: Invalid operation"));
  }

  @Test
  public void testLeadingOrTrailing() {
    Assertions.assertEquals("Disk almost full", LogLevels.message("[WARNING]:  Disk almost full\r\n"));
  }

  @Test
  public void testLogLineLogLevel() {
    Assertions.assertEquals("error", LogLevels.logLevel("[ERROR]: Invalid operation"));
  }

  @Test
  public void testReformatsLogLine() {
    Assertions.assertEquals("Operation completed (info)", LogLevels.reformat("[INFO]: Operation completed"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The message method returns the log line's message of a warning log")
  public void warning_message() {
    Assertions.assertEquals("Disk almost full", LogLevels.message("[WARNING]: Disk almost full"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The message method returns the log line's message of an info log")
  public void info_message() {
    Assertions.assertEquals("File moved", LogLevels.message("[INFO]: File moved"));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The message method returns the log line's message after removing leading and trailing spaces")
  public void message_with_leading_and_trailing_white_space() {
    Assertions.assertEquals("Timezone not set", LogLevels.message("[WARNING]:   \tTimezone not set  \r\n"));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The logLevel method returns the log level of an error log line")
  public void error_log_level() {
    Assertions.assertEquals("error", LogLevels.logLevel("[ERROR]: Disk full"));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The logLevel method returns the log level of a warning log line")
  public void warning_log_level() {
    Assertions.assertEquals("warning", LogLevels.logLevel("[WARNING]: Unsafe password"));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The logLevel method returns the log level of an info log line")
  public void info_log_level() {
    Assertions.assertEquals("info", LogLevels.logLevel("[INFO]: Timezone changed"));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The reformat method correctly reformats an error log line")
  public void error_reformat() {
    Assertions.assertEquals("Segmentation fault (error)", LogLevels.reformat("[ERROR]: Segmentation fault"));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The reformat method correctly reformats a warning log line")
  public void warning_reformat() {
    Assertions.assertEquals("Decreased performance (warning)", LogLevels.reformat("[WARNING]: Decreased performance"));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The reformat method correctly reformats an info log line")
  public void info_reformat() {
    Assertions.assertEquals("Disk defragmented (info)", LogLevels.reformat("[INFO]: Disk defragmented"));
  }

  @Test
  @Tag("task:3")
  @DisplayName("The reformat method correctly reformats an error log line removing spaces")
  public void reformat_with_leading_and_trailing_white_space() {
    Assertions.assertEquals("Corrupt disk (error)", LogLevels.reformat("[ERROR]: \t Corrupt disk\t \t \r\n"));
  }
}