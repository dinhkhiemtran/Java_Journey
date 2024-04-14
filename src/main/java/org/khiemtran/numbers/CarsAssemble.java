package org.khiemtran.numbers;

public class CarsAssemble {
  private static final int NUMBER_IN_HOURS = 221;

  public double productionRatePerHour(int speed) {
    return NUMBER_IN_HOURS * speed * getSpeed(speed);
  }

  public int workingItemsPerMinute(int speed) {
    return (int) productionRatePerHour(speed) / 60;
  }

  private double getSpeed(int speed) {
    switch (speed) {
      case 1, 2, 3, 4 -> {
        return 1.0;
      }
      case 5, 6, 7, 8 -> {
        return 0.9;
      }
      case 9 -> {
        return 0.8;
      }
      case 10 -> {
        return 0.77;
      }
      default -> {
        return 0.0;
      }
    }
  }
}
