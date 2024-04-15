package org.khiemtran.strings;

public class SqueakyClean {
  public String clean(String identifier) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0 ; i < identifier.length(); i++) {
      char ch = identifier.charAt(i);
      if (Character.isSpaceChar(ch)) {
        stringBuilder.append("_");
      } else if (ch == '-') {
        i++;
        stringBuilder.append(Character.toUpperCase(identifier.charAt(i)));
      } else if (!Character.isLetter(ch)) {
        switch (ch) {
          case '0' -> stringBuilder.append('o');
          case '1' -> stringBuilder.append('l');
          case '3' -> stringBuilder.append('e');
          case '4'-> stringBuilder.append('a');
          case '7' -> stringBuilder.append('t');
        }
      } else {
        stringBuilder.append(ch);
      }
    }
    return stringBuilder.toString();
  }
}
