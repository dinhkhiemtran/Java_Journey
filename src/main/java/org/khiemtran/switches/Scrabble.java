package org.khiemtran.switches;

public class Scrabble {
  private final String word;

  Scrabble(String word) {
    this.word = word.toUpperCase();
  }

  int getScore() {
    return word.chars()
        .mapToObj(ch -> (char) ch)
        .map(this::getPoints)
        .mapToInt(i -> i)
        .sum();
  }

  private int getPoints(Character ch) {
    switch (ch) {
      case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> {
        return 1;
      }
      case 'D', 'G' -> {
        return 2;
      }
      case 'B', 'C', 'M', 'P' -> {
        return 3;
      }
      case 'F', 'H', 'V', 'W', 'Y' -> {
        return 4;
      }
      case 'K' -> {
        return 5;
      }
      case 'J', 'X' -> {
        return 8;
      }
      case 'Q', 'Z' -> {
        return 10;
      }
      default -> {
        return 0;
      }
    }
  }
}
