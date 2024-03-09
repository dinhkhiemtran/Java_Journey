package org.khiemtran.basics.test_track;

public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
  private final static int DRIVES_UNITS = 10;
  private int distance;
  private int numberOfVictories;

  public ProductionRemoteControlCar() {
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

  public int getNumberOfVictories() {
    return numberOfVictories;
  }

  public void setNumberOfVictories(int numberOfVictories) {
    this.numberOfVictories = numberOfVictories;
  }

  @Override
  public int compareTo(ProductionRemoteControlCar o) {
    return Integer.compare(o.getNumberOfVictories(), this.getNumberOfVictories());
  }
}
