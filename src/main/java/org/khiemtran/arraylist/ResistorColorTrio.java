package org.khiemtran.arraylist;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResistorColorTrio {
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

  String label(String[] colors) {
    StringBuilder stringBuilder = new StringBuilder();
    extracted(colors, stringBuilder);
    String value = getString(colors);
    switch (colors[2]) {
      case "black" -> stringBuilder.append(value).append(" ohms");
      case "brown" -> stringBuilder.append(value).append("0 ohms");
      case "yellow" -> stringBuilder.append(value).append("0 kiloohms");
      case "blue" -> stringBuilder.append(value).append(" megaohms");
      case "white" -> stringBuilder.append(value).append(" gigaohms");
      default -> stringBuilder.append(value).append(" kiloohms");
    }
    return stringBuilder.toString();
  }

  private String getString(String[] colors) {
    return Stream.iterate(0, i -> i + 1)
        .limit(2)
        .filter(i -> !(colors[i].equals("black")))
        .map(i -> Arrays.asList(COLORS).indexOf(colors[i]))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  private static void extracted(String[] colors, StringBuilder stringBuilder) {
    if (colors[0].equals("black") && colors[1].equals("black")) {
      stringBuilder.append("0");
    }
  }
}