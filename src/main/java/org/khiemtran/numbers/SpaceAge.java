package org.khiemtran.numbers;

import java.util.HashMap;
import java.util.Map;

public class SpaceAge {
  private double seconds;

  public enum Planet {
    EARTH,
    MERCURY,
    VENUS,
    MARS,
    JUPITER,
    SATURN,
    URANUS,
    NEPTUNE
  }

  private final static Map<Planet, Double> PLANET_MAP = new HashMap<>();

  static {
    PLANET_MAP.put(Planet.EARTH, 31557600d);
    PLANET_MAP.put(Planet.MERCURY, 0.2408467);
    PLANET_MAP.put(Planet.VENUS, 0.61519726);
    PLANET_MAP.put(Planet.MARS, 1.8808158);
    PLANET_MAP.put(Planet.JUPITER, 11.862615);
    PLANET_MAP.put(Planet.SATURN, 29.447498);
    PLANET_MAP.put(Planet.URANUS, 84.016846);
    PLANET_MAP.put(Planet.NEPTUNE, 164.79132);
  }

  SpaceAge(double seconds) {
    this.seconds = seconds;
  }

  double getSeconds() {
    return seconds;
  }

  double onEarth() {
    return calculateCustomTime(getSeconds(), Planet.EARTH);
  }

  double onMercury() {
    return calculateCustomTime(onEarth(), Planet.MERCURY);
  }

  double onVenus() {
    return calculateCustomTime(onEarth(), Planet.VENUS);
  }

  double onMars() {
    return calculateCustomTime(onEarth(), Planet.MARS);
  }

  double onJupiter() {
    return calculateCustomTime(onEarth(), Planet.JUPITER);
  }

  double onSaturn() {
    return calculateCustomTime(onEarth(), Planet.SATURN);
  }

  double onUranus() {
    return calculateCustomTime(onEarth(), Planet.URANUS);
  }

  double onNeptune() {
    return calculateCustomTime(onEarth(), Planet.NEPTUNE);
  }

  static double calculateCustomTime(double seconds, Planet planet) {
    return (double) Math.round((seconds / PLANET_MAP.get(planet)) * 100) / 100;
  }
}
