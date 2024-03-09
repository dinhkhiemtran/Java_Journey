package org.khiemtran.basics;

public class ElonsToyCar {
  private int meters;
  private int battery;

  public ElonsToyCar() {
    this.meters = 0;
    this.battery = 100;
  }

  public static ElonsToyCar buy() {
    return new ElonsToyCar();
  }

  public String distanceDisplay() {
    return String.format("Driven %d meters", meters);
  }

  public String batteryDisplay() {
    return battery != 0 ? String.format("Battery at %d%%", battery) : "Battery empty";
  }

  public void drive() {
    if (battery != 0) {
      this.meters += 20;
      battery = battery - 1;
    }
  }
}
