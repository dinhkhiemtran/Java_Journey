package org.khiemtran.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
  String reverse(String inputString) {
    char[] charsArray = inputString.toCharArray();
    return IntStream.range(0, charsArray.length)
        .mapToObj(i -> charsArray[charsArray.length - 1 - i])
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
