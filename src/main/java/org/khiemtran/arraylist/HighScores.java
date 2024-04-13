package org.khiemtran.arraylist;

import java.util.Collections;
import java.util.List;

public class HighScores {
  private final List<Integer> highScores;

  public HighScores(List<Integer> highScores) {
    this.highScores = highScores;
  }

  List<Integer> scores() {
    return highScores;
  }

  Integer latest() {
    return highScores.get(highScores.size() - 1);
  }

  Integer personalBest() {
    return highScores.stream()
        .mapToInt(Integer::intValue)
        .max().orElse(0);
  }

  List<Integer> personalTopThree() {
    return highScores.stream()
        .sorted(Collections.reverseOrder())
        .limit(3)
        .toList();
  }
}