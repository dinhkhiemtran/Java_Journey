package org.khiemtran.arraylist;

import java.util.stream.Stream;

public class ResistorColor {
  private final String[] COLORS = new String[]{
      "black",
      "brown",
      "red",
      "orange",
      "yellow",
      "green",
      "blue",
      "violet",
      "grey",
      "white"
  };

  public int colorCode(String color) {
    return Stream.iterate(0, i -> i + 1)
        .limit(COLORS.length)
        .filter(i -> color.equals(COLORS[i]))
        .mapToInt(i -> i)
        .findFirst()
        .orElseThrow();
  }

  public String[] colors() {
    return COLORS;
  }
}