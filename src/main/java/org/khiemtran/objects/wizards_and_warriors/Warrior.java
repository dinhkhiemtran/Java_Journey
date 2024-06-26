package org.khiemtran.objects.wizards_and_warriors;

public class Warrior extends Fighter {
  public String toString() {
    return String.format("Fighter is a %s", this.getClass().getSimpleName());
  }

  @Override
  boolean isVulnerable() {
    return false;
  }

  @Override
  int getDamagePoints(Fighter fighter) {
    return fighter.isVulnerable() ? 10 : 6;
  }
}