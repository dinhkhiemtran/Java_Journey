package org.khiemtran.numbers;

import java.util.concurrent.atomic.AtomicInteger;

public class IsbnVerifier {
  private static final int X_DEFAULT = 10;

  boolean isValid(String stringToVerify) {
    stringToVerify = stringToVerify.replace("-", "");
    if (stringToVerify.isEmpty()) return false;
    if (isInValidFormat(stringToVerify)) return false;
    AtomicInteger decrease = new AtomicInteger(stringToVerify.length());
    return stringToVerify.chars()
        .mapToObj(ch -> (ch == 'X' ? X_DEFAULT : Character.getNumericValue((char) ch)) * decrease.getAndDecrement())
        .mapToInt(i -> i)
        .sum() % 11 == 0;
  }

  private static boolean isInValidFormat(String stringToVerify) {
    int lastIndex = stringToVerify.length() - 1;
    boolean hasInvalidLastCharacter = stringToVerify.charAt(lastIndex) != 'X' &&
        !(Character.isDigit(stringToVerify.charAt(lastIndex)));
    boolean hasLetter = stringToVerify.substring(0, lastIndex)
        .chars()
        .anyMatch(Character::isLetter);
    boolean hasInvalidSize = stringToVerify.length() != 10;
    return hasInvalidLastCharacter || hasLetter || hasInvalidSize;
  }
}
