package org.khiemtran.numbers;

public class EliudsEggs {
  public int eggCount(int number) {
    return (int) Integer.toBinaryString(number)
        .chars()
        .filter(ch -> ch == '1')
        .count();
  }
}
