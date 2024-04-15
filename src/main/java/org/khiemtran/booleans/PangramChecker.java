package org.khiemtran.booleans;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {
  private static final String ALPHABETICAL;

  static {
    ALPHABETICAL = IntStream.rangeClosed('a', 'z')
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
  }

  public boolean isPangram(String input) {
    return input.toLowerCase().chars()
        .distinct()
        .mapToObj(ch -> (char) ch)
        .filter(Character::isLetter)
        .map(String::valueOf)
        .collect(Collectors.joining()).length() == ALPHABETICAL.length();
  }
}
