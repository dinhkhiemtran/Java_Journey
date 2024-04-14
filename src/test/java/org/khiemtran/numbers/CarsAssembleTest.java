package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.numbers.CarsAssemble;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class CarsAssembleTest {
  private static final double epsilon = 0.0001;

  @Test
  @Tag("task:1")
  @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 0")
  public void productionRatePerHourForSpeedZero() {
    assertThat(new CarsAssemble().productionRatePerHour(0)).isCloseTo(0.0, within(epsilon));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 1")
  public void productionRatePerHourForSpeedOne() {
    assertThat(new CarsAssemble().productionRatePerHour(1)).isCloseTo(221.0, within(epsilon));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 4")
  public void productionRatePerHourForSpeedFour() {
    assertThat(new CarsAssemble().productionRatePerHour(4)).isCloseTo(884.0, within(epsilon));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 7")
  public void productionRatePerHourForSpeedSeven() {
    assertThat(new CarsAssemble().productionRatePerHour(7)).isCloseTo(1392.3, within(epsilon));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 9")
  public void productionRatePerHourForSpeedNine() {
    assertThat(new CarsAssemble().productionRatePerHour(9)).isCloseTo(1591.2, within(epsilon));
  }

  @Test
  @Tag("task:1")
  @DisplayName("The productionRatePerHour method returns the correct result when line's speed is 10")
  public void productionRatePerHourForSpeedTen() {
    assertThat(new CarsAssemble().productionRatePerHour(10)).isCloseTo(1701.7, within(epsilon));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The workingItemsPerMinute should be 0 when line's speed is 0")
  public void workingItemsPerMinuteForSpeedZero() {
    Assertions.assertEquals(0, new CarsAssemble().workingItemsPerMinute(0));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The workingItemsPerMinute should be 3 when line's speed is 1")
  public void workingItemsPerMinuteForSpeedOne() {
    Assertions.assertEquals(3, new CarsAssemble().workingItemsPerMinute(1));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The workingItemsPerMinute should be 16 when line's speed is 5")
  public void workingItemsPerMinuteForSpeedFive() {
    Assertions.assertEquals(16, new CarsAssemble().workingItemsPerMinute(5));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The workingItemsPerMinute should be 26 when line's speed is 8")
  public void workingItemsPerMinuteForSpeedEight() {
    Assertions.assertEquals(26, new CarsAssemble().workingItemsPerMinute(8));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The workingItemsPerMinute should be 26 when line's speed is 9")
  public void workingItemsPerMinuteForSpeedNine() {
    Assertions.assertEquals(26, new CarsAssemble().workingItemsPerMinute(9));
  }

  @Test
  @Tag("task:2")
  @DisplayName("The workingItemsPerMinute should be 28 when line's speed is 10")
  public void workingItemsPerMinuteForSpeedTen() {
    Assertions.assertEquals(28, new CarsAssemble().workingItemsPerMinute(10));
  }
}