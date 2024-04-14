package org.khiemtran.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.khiemtran.strings.ElonsToyCar;

class ElonsToyCarTest {
  private ElonsToyCar car;

  @Test
  public void testDistanceDisplay() {
    Assertions.assertEquals("Driven 0 meters", new ElonsToyCar().distanceDisplay());
  }

  @Test
  public void testBatteryDisplay() {
    Assertions.assertEquals("Battery at 100%", new ElonsToyCar().batteryDisplay());
  }

  @Test
  public void numberOfMetersDriven() {
    car = new ElonsToyCar();
    car.drive();
    car.drive();
    Assertions.assertEquals("Driven 40 meters", car.distanceDisplay());
  }

  @Test
  public void testBatteryPercentage() {
    car = new ElonsToyCar();
    car.drive();
    car.drive();
    Assertions.assertEquals("Battery at 98%", car.batteryDisplay());
  }

  @Test
  public void testIncreaseDistanceDriven() {
    car = new ElonsToyCar();
    for (int i = 1; i <= 100; i++) {
      car.drive();
    }
    System.out.println(car.distanceDisplay());
    System.out.println(car.batteryDisplay());
    Assertions.assertEquals("Driven 2000 meters", car.distanceDisplay());
    Assertions.assertEquals("Battery empty", car.batteryDisplay());
  }

  @Test
  @Tag("task:1")
  @DisplayName("The static buy method returns a new remote controlled car instance")
  public void buy_new_car_returns_instance() {
    ElonsToyCar car = ElonsToyCar.buy();
    Assertions.assertNotNull(car);
  }

  @Test
  @Tag("task:1")
  @DisplayName("The static buy method returns each time a new remote controlled car instance")
  public void buy_new_car_returns_new_car_each_time() {
    ElonsToyCar car1 = ElonsToyCar.buy();
    ElonsToyCar car2 = ElonsToyCar.buy();
    Assertions.assertNotEquals(car1, car);
  }

  @Test
  @Tag("task:2")
  @DisplayName("The distanceDisplay method shows 0 meters message on a new car")
  public void new_car_distance_display() {
    ElonsToyCar car = new ElonsToyCar();
    Assertions.assertEquals("Driven 0 meters", car.distanceDisplay());
  }

  @Test
  @Tag("task:3")
  @DisplayName("The batteryDisplay method shows full battery message on a new car")
  public void new_car_battery_display() {
    ElonsToyCar car = new ElonsToyCar();
    Assertions.assertEquals("Battery at 100%", car.batteryDisplay());
  }

  @Test
  @Tag("task:4")
  @DisplayName("The distanceDisplay method shows the correct message after driving once")
  public void distance_display_after_driving_once() {
    ElonsToyCar car = new ElonsToyCar();
    car.drive();
    Assertions.assertEquals("Driven 20 meters", car.distanceDisplay());
  }

  @Test
  @Tag("task:4")
  @DisplayName("The distanceDisplay method shows the correct message after driving multiple times")
  public void distance_display_after_driving_multiple_times() {
    ElonsToyCar car = new ElonsToyCar();
    for (int i = 0; i < 17; i++) {
      car.drive();
    }
    Assertions.assertEquals("Driven 340 meters", car.distanceDisplay());
  }

  @Test
  @Tag("task:5")
  @DisplayName("The batteryDisplay method shows the correct message after driving once")
  public void battery_display_after_driving_once() {
    ElonsToyCar car = new ElonsToyCar();
    car.drive();
    Assertions.assertEquals("Battery at 99%", car.batteryDisplay());
  }

  @Test
  @Tag("task:5")
  @DisplayName("The batteryDisplay method shows the correct battery percentage after driving multiple times")
  public void battery_display_after_driving_multiple_times() {
    ElonsToyCar car = new ElonsToyCar();
    for (int i = 0; i < 23; i++) {
      car.drive();
    }
    Assertions.assertEquals("Battery at 77%", car.batteryDisplay());
  }

  @Test
  @Tag("task:5")
  @DisplayName("The batteryDisplay method shows battery empty after draining all battery")
  public void battery_display_when_battery_empty() {
    ElonsToyCar car = new ElonsToyCar();
    // Drain the battery
    for (int i = 0; i < 100; i++) {
      car.drive();
    }
    // Attempt to drive one more time (should not work)
    car.drive();
    Assertions.assertEquals("Battery empty",car.batteryDisplay());
  }

  @Test
  @Tag("task:6")
  @DisplayName("The distanceDisplay method shows the correct message after driving and draining all battery")
  public void distance_display_when_battery_empty() {
    ElonsToyCar car = new ElonsToyCar();
    // Drain the battery
    for (int i = 0; i < 100; i++) {
      car.drive();
    }
    // Attempt to drive one more time (should not work)
    car.drive();
    Assertions.assertEquals("Driven 2000 meters", car.distanceDisplay());
  }
}