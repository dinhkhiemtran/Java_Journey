package org.khiemtran.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Acronym {
  private String phrase;

  Acronym(String phrase) {
    this.phrase = phrase.replace("-", " ")
        .replace("_", " ")
        .replaceAll("\\s+", " ");
  }

  String get() {
    return Arrays.stream(phrase.split(" "))
        .map(word -> word.chars()
            .mapToObj(ch -> (char) ch)
            .findFirst()
            .orElse(null))
        .map(String::valueOf)
        .collect(Collectors.joining())
        .toUpperCase();
  }
}