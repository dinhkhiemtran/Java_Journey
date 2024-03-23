package org.khiemtran.basics;

public class Twofer {
  private static final String DIALOGUE = "One for %s, one for me.";

  public String twofer(String name) {
    return String.format(DIALOGUE, (name == null) ? "you" : name);
  }
}
