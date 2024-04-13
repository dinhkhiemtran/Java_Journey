package org.khiemtran.numbers;

public class ArmstrongNumbers {
  boolean isArmstrongNumber(int numberToCheck) {
    String numbers = String.valueOf(numberToCheck);
    return numberToCheck == String.valueOf(numberToCheck)
        .chars().parallel()
        .mapToObj(Character::getNumericValue)
        .mapToInt(number -> (int) Math.pow(number, numbers.length()))
        .sum();
  }
}