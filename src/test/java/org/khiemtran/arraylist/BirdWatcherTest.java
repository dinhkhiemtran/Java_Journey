package org.khiemtran.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.khiemtran.arraylist.BirdWatcher;

class BirdWatcherTest {
  @Test
  public void testGetCountForFirstDay() {
    int[] birdsPerDay = {2, 5, 0, 7, 4, 1};
    BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
    Assertions.assertEquals(14, birdCount.getCountForFirstDays(4));
  }

  @Test
  public void testGetLstWeek() {
    int[] expect = {2, 5, 0, 7, 4, 1};
    BirdWatcher actual = new BirdWatcher(expect);
    Assertions.assertArrayEquals(expect, actual.getLastWeek());
  }

  @Test
  public void testGetToday() {
    int[] birdsPerDay = {2, 5, 0, 7, 4, 1};
    Assertions.assertEquals(1, new BirdWatcher(birdsPerDay).getToday());
  }

  @Test
  public void testHasWithoutBirds() {
    int[] birdsPerDay = {2, 5, 0, 7, 4, 1};
    Assertions.assertTrue(new BirdWatcher(birdsPerDay).hasDayWithoutBirds());
  }

  @Test
  public void testGetBusyDays() {
    int[] birdsPerDay = {2, 5, 0, 7, 4, 1};
    Assertions.assertEquals(2, new BirdWatcher(birdsPerDay).getBusyDays());
  }

  @Test
  public void testIncrement() {
    int[] birdsPerDay = {2, 5, 0, 7, 4, 1};
    BirdWatcher birdWatcher = new BirdWatcher(birdsPerDay);
    birdWatcher.incrementTodaysCount();
    Assertions.assertArrayEquals(new int[]{2, 5, 0, 7, 4, 2}, birdWatcher.getLastWeek());
  }
}