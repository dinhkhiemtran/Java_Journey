package org.khiemtran.basics.test_track;

public class ExperimentalRemoteControlCar implements RemoteControlCar {
  private final static int DRIVES_UNITS = 20;
  private int distance;

  public ExperimentalRemoteControlCar() {
    this.distance = 0;
  }

  @Override
  public void drive() {
    distance += DRIVES_UNITS;
  }

  @Override
  public int getDistanceTravelled() {
    return distance;
  }
}
