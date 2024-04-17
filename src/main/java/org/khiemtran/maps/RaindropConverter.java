package org.khiemtran.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RaindropConverter {
  private static final Map<Integer, String> RAIN_DROP = new HashMap<>();

  static {
    RAIN_DROP.put(3, "Pling");
    RAIN_DROP.put(5, "Plang");
    RAIN_DROP.put(7, "Plong");
  }

  String convert(int number) {
    String sounds = RAIN_DROP.keySet()
        .stream()
        .filter(k -> number % k == 0)
        .map(RAIN_DROP::get)
        .collect(Collectors.joining());
    return sounds.isEmpty() ? String.valueOf(number) : sounds;
  }
}
