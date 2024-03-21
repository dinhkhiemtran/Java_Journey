package org.khiemtran.random;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class RandomExample {
  private final static List<String> MOBILES = List.of("Apple", "Samsung", "Huawei", "Xiaomi", "Oppo", "Vivo", "OnePlus", "Sony", "Nokia", "Lenovo", "Asus");

  //Using Math.Random 0 -> mobiles.length
  public static String randomMathMobile() {
    return MOBILES.get((int) (Math.random() * MOBILES.size()));
  }

  //Math.Random Huawei() -> Nokia
  public static String randomMathRange() {
    int min = MOBILES.indexOf("Huawei");
    int max = MOBILES.indexOf("Nokia");
    return MOBILES.get((int) (min + (Math.random() * (max - min) + 1)));
  }

  //Using Random class 0 -> mobiles.length
  public static String randomClassMobiles() {
    return MOBILES.get(new Random().nextInt(MOBILES.size()));
  }

  //Random class Huawei() -> Nokia
  public static String randomClassRange() {
    int min = MOBILES.indexOf("Huawei");
    int max = MOBILES.indexOf("Nokia");
    return MOBILES.get(new Random().nextInt((max - min) + 1) + min);
  }

  //SecureRandom like Random class, we have security-sensitive applications
  public static String secureRandom() {
    int min = MOBILES.indexOf("Huawei");
    int max = MOBILES.indexOf("Nokia");
    return MOBILES.get(new SecureRandom().nextInt((max - min) + 1) + min);
  }

  public static void main(String[] args) {
    for (int i = 0; i < MOBILES.size(); i++) {
      System.out.println(secureRandom());
    }
  }
}
