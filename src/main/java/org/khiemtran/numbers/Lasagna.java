package org.khiemtran.numbers;

public class Lasagna {
  private final static int OVEN_TIME = 40;
  private final static int PER_MINUTE = 2;

  public int expectedMinutesInOven() {
    return OVEN_TIME;
  }

  public int remainingMinutesInOven(int minutes) {
    return expectedMinutesInOven() - minutes;
  }

  public int preparationTimeInMinutes(int layer) {
    return layer * PER_MINUTE;
  }

  public int totalTimeInMinutes(int layers, int minute) {
    return preparationTimeInMinutes(layers) + minute;
  }
}
