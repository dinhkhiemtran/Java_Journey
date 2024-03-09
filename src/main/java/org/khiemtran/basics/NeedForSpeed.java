package org.khiemtran.basics;

public class NeedForSpeed {
  private int speed;
  private int batteryDrain;
  private int distance;
  private int battery;

  NeedForSpeed(int speed, int batteryDrain) {
    this.speed = speed;
    this.batteryDrain = batteryDrain;
    this.distance = 0;
    this.battery = 100;
  }

  public boolean batteryDrained() {
    return battery < this.batteryDrain;
  }

  public int distanceDriven() {
    return distance;
  }

  public void drive() {
    if (!batteryDrained()) {
      distance = distance + speed;
      battery = battery - batteryDrain;
    }
  }

  public static NeedForSpeed nitro() {
    return new NeedForSpeed(50, 4);
  }
}

class RaceTrack {
  private int distance;

  RaceTrack(int distance) {
    this.distance = distance;
  }

  public int getDistance() {
    return distance;
  }

  public boolean tryFinishTrack(NeedForSpeed car) {
    implementFinishTheRaceTrack(car);
    return car.distanceDriven() >= this.getDistance();
  }

  private void implementFinishTheRaceTrack(NeedForSpeed car) {
    while (!car.batteryDrained() && car.distanceDriven() < this.getDistance()) {
      car.drive();
    }
  }
}
