package org.khiemtran.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Say {
  private static final Map<Long, String> NUMBERS_MAP = new HashMap<>();

  static {
    NUMBERS_MAP.put(0L, "zero");
    NUMBERS_MAP.put(1L, "one");
    NUMBERS_MAP.put(2L, "two");
    NUMBERS_MAP.put(3L, "three");
    NUMBERS_MAP.put(4L, "four");
    NUMBERS_MAP.put(5L, "five");
    NUMBERS_MAP.put(6L, "six");
    NUMBERS_MAP.put(7L, "seven");
    NUMBERS_MAP.put(8L, "eight");
    NUMBERS_MAP.put(9L, "nine");
    NUMBERS_MAP.put(10L, "ten");
    NUMBERS_MAP.put(11L, "eleven");
    NUMBERS_MAP.put(12L, "twelve");
    NUMBERS_MAP.put(13L, "thirteen");
    NUMBERS_MAP.put(14L, "fourteen");
    NUMBERS_MAP.put(15L, "fifteen");
    NUMBERS_MAP.put(16L, "sixteen");
    NUMBERS_MAP.put(17L, "seventeen");
    NUMBERS_MAP.put(18L, "eighteen");
    NUMBERS_MAP.put(19L, "nineteen");
    NUMBERS_MAP.put(20L, "twenty");
    NUMBERS_MAP.put(30L, "thirty");
    NUMBERS_MAP.put(40L, "forty");
    NUMBERS_MAP.put(50L, "fifty");
    NUMBERS_MAP.put(60L, "sixty");
    NUMBERS_MAP.put(70L, "seventy");
    NUMBERS_MAP.put(80L, "eighty");
    NUMBERS_MAP.put(90L, "ninety");
  }

  public String say(long number) {
    if (number < 0 || number >= 1_000_000_000_000L) {
      throw new IllegalArgumentException();
    }
    if (NUMBERS_MAP.containsKey(number)) {
      return NUMBERS_MAP.get(number);
    } else if (number < 100) {
      return getDozens(number);
    } else if (number < 1_000) {
      return getHundreds(number);
    } else if (number < 10_000) {
      return getThousands(number);
    } else if (number < 10_000_000) {
      return getMillion(number);
    } else {
      return getBillion(number);
    }
  }

  private String getBillion(long number) {
    StringBuilder stringBuilder = new StringBuilder();
    String s = String.valueOf(number);
    if (s.substring(1).equals("000000000")) {
      stringBuilder.append(NUMBERS_MAP.get(number / 1_000_000_000L));
      stringBuilder.append(" billion");
      return stringBuilder.toString();
    } else {
      List<String> denotes = Stream.iterate(0, i -> i < s.length(), i -> i + 3)
          .map(i -> getHundreds(Long.parseLong(s.substring(i, Math.min(s.length(), i + 3)))))
          .toList();
      denotes.forEach(System.out::println);
      stringBuilder.append(denotes.get(0));
      stringBuilder.append(" billion ");
      stringBuilder.append(denotes.get(1));
      stringBuilder.append(" million ");
      stringBuilder.append(denotes.get(2));
      stringBuilder.append(" thousand ");
      stringBuilder.append(denotes.get(3));
      return stringBuilder.toString();
    }
  }

  private String getMillion(long number) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(NUMBERS_MAP.get(number / 1_000_000L));
    stringBuilder.append(" million");
    String subNumbers = String.valueOf(number).substring(1);
    if (subNumbers.equals("000000")) {
      return stringBuilder.toString();
    } else {
      String hundreds = getThousands(Long.parseLong(subNumbers));
      return stringBuilder
          .append(" ")
          .append(hundreds).toString();
    }
  }

  private String getThousands(long number) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(NUMBERS_MAP.get(number / 1000L))
        .append(" thousand");
    String subNumbers = String.valueOf(number).substring(1);
    if (subNumbers.equals("000")) {
      return stringBuilder.toString();
    } else {
      String hundreds = getHundreds(Long.parseLong(subNumbers));
      return stringBuilder
          .append(" ")
          .append(hundreds).toString();
    }
  }

  private String getHundreds(long number) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(NUMBERS_MAP.get(number / 100L));
    stringBuilder.append(" hundred");
    String subNumbers = String.valueOf(number).substring(1);
    if (subNumbers.equals("00")) {
      return stringBuilder.toString();
    } else {
      String dozens = getDozens(Long.parseLong(subNumbers));
      return stringBuilder.append(" ").append(dozens).toString();
    }
  }

  private String getDozens(long number) {
    return NUMBERS_MAP.get((number / 10L) * 10) + "-" + NUMBERS_MAP.get(number % 10L);
  }
}
