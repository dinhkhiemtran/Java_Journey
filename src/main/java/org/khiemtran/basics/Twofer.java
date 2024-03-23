package org.khiemtran.basics;

public class Twofer {
  public String twofer(String name) {
    return "One for " + (name == null ? "you" : name) + ", one for me.";
  }
}
