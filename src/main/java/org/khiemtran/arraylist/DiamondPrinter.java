package org.khiemtran.arraylist;

import java.util.Arrays;
import java.util.List;

public class DiamondPrinter {
  List<String> printToList(char a) {
    int diff = Character.isUpperCase(a) ? a - 'A' : a - 'a';
    int size = 2 * diff + 1;
    int halfLength = size / 2;
    String[] lines = new String[size];
    for (int i = 0; i < halfLength + 1; i++) {
      char c = (char) ('A' + i);
      int leftPosition = halfLength + 1 - i - 1;
      int rightPosition = size - leftPosition - 1;
      char[] buffer = new char[size];
      Arrays.fill(buffer, ' ');
      buffer[leftPosition] = c;
      buffer[rightPosition] = c;
      String line = new String(buffer);
      lines[i] = line;
      lines[size - 1 - i] = line;
    }
    return Arrays.asList(lines);
  }
}

