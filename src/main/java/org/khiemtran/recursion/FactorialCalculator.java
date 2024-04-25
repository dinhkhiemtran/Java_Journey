package org.khiemtran.recursion;

public class FactorialCalculator {
  public int factorial(int number) {
    return number == 1 || number == 0 ? 1 : number * factorial(number - 1);
  }

  public static void main(String[] args) {
  }
}
