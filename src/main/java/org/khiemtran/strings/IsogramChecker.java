package org.khiemtran.strings;

public class IsogramChecker {
  boolean isIsogram(String phrase) {
    phrase = phrase.replaceAll("\\W", "").toLowerCase();
    return phrase.chars()
        .distinct()
        .count() == phrase.length();
  }
}
