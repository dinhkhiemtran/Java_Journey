package org.khiemtran.randoms;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DnDCharacter {
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;
  private int hitPoints;

  public DnDCharacter() {
    this.strength = ability(rollDice());
    this.dexterity = ability(rollDice());
    this.constitution = ability(rollDice());
    this.intelligence = ability(rollDice());
    this.wisdom = ability(rollDice());
    this.charisma = ability(rollDice());
    this.hitPoints = 10 + modifier(getConstitution());
  }

  int ability(List<Integer> scores) {
    return scores.stream()
        .sorted(Collections.reverseOrder())
        .limit(3)
        .mapToInt(Integer::intValue)
        .sum();
  }

  List<Integer> rollDice() {
    return new Random().ints(4, 1, 7)
        .boxed()
        .collect(Collectors.toList());
  }

  int modifier(int input) {
    return (int) Math.floor(((double) input - 10.0) / 2.0);
  }

  int getStrength() {
    return strength;
  }

  int getDexterity() {
    return dexterity;
  }

  int getConstitution() {
    return constitution;
  }

  int getIntelligence() {
    return intelligence;
  }

  int getWisdom() {
    return wisdom;
  }

  int getCharisma() {
    return charisma;
  }

  int getHitpoints() {
    return hitPoints;
  }
}