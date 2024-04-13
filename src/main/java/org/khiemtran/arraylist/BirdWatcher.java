package org.khiemtran.arraylist;

import java.util.Arrays;

public class BirdWatcher {
  private final int[] birdsPerDay;

  public BirdWatcher(int[] birdsPerDay) {
    this.birdsPerDay = birdsPerDay.clone();
  }

  public int[] getLastWeek() {
    return birdsPerDay;
  }

  public int getToday() {
    return birdsPerDay[birdsPerDay.length - 1];
  }

  public void incrementTodaysCount() {
    birdsPerDay[birdsPerDay.length - 1] = getToday() + 1;
  }

  public boolean hasDayWithoutBirds() {
    return Arrays.stream(birdsPerDay).anyMatch(bird -> bird == 0);
  }

  public int getCountForFirstDays(int numberOfDays) {
    return Arrays.stream(birdsPerDay).limit(numberOfDays).sum();
  }

  public int getBusyDays() {
    return (int) Arrays.stream(birdsPerDay).filter(bird -> bird >= 5).count();
  }
}
