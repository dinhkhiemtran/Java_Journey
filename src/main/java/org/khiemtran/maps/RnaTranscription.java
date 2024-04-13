package org.khiemtran.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RnaTranscription {
  private static final Map<Character, Character> TRANSCRIPTION = new HashMap<>();

  static {
    TRANSCRIPTION.put('G', 'C');
    TRANSCRIPTION.put('C', 'G');
    TRANSCRIPTION.put('T', 'A');
    TRANSCRIPTION.put('A', 'U');
  }

  String transcribe(String dnaStrand) {
    return dnaStrand.isEmpty() ? "" :
        dnaStrand.chars()
            .mapToObj(ch -> (char) ch)
            .filter(TRANSCRIPTION::containsKey)
            .map(TRANSCRIPTION::get)
            .map(String::valueOf)
            .collect(Collectors.joining());
  }
}