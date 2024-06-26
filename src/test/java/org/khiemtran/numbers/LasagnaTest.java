package org.khiemtran.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.numbers.Lasagna;

import static org.assertj.core.api.Assertions.assertThat;

class LasagnaTest {
  @Test
  @Tag("task:1")
  @DisplayName("The expectedMinutesInOven method returns the correct value")
  public void expected_minutes_in_oven() {
    assertThat(new Lasagna().expectedMinutesInOven()).isEqualTo(40);
  }

  @Test
  @Tag("task:2")
  @DisplayName("The remainingMinutesInOven method calculates and returns the correct value")
  public void remaining_minutes_in_oven() {
    assertThat(new Lasagna().remainingMinutesInOven(25)).isEqualTo(15);
  }

  @Test
  @Tag("task:3")
  @DisplayName("The preparationTimeInMinutes method calculates the correct value for multiple layers")
  public void preparation_time_in_minutes_for_multiple_layers() {
    assertThat(new Lasagna().preparationTimeInMinutes(4)).isEqualTo(8);
  }

  @Test
  @Tag("task:3")
  @DisplayName("The preparationTimeInMinutes method calculates the correct value for single layer")
  public void preparation_time_in_minutes_for_one_layer() {
    assertThat(new Lasagna().preparationTimeInMinutes(1)).isEqualTo(2);
  }

  @Test
  @Tag("task:4")
  @DisplayName("The totalTimeInMinutes method calculates the correct value for single layer")
  public void total_time_in_minutes_for_one_layer() {
    Assertions.assertEquals(32, new Lasagna().totalTimeInMinutes(1, 30));
  }

  @Test
  @Tag("task:4")
  @DisplayName("The totalTimeInMinutes method calculates the correct value for multiple layers")
  public void total_time_in_minutes_for_multiple_layers() {
    assertThat(new Lasagna().totalTimeInMinutes(4, 8)).isEqualTo(16);
  }
}