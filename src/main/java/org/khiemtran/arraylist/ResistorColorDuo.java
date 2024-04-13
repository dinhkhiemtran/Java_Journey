package org.khiemtran.arraylist;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResistorColorDuo {
  private final String[] COLORS = {
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

  int value(String[] colors) {
    return Integer.parseInt(Stream.iterate(0, i -> i + 1)
        .limit(2)
        .map(i -> Arrays.asList(COLORS).indexOf(colors[i]))
        .map(String::valueOf)
        .collect(Collectors.joining()));
  }
}