package org.khiemtran.randoms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DnDCharacterTest {
  private DnDCharacter dnDCharacter;

  @BeforeEach
  public void setup() {
    dnDCharacter = new DnDCharacter();
  }

  @Test
  public void testAbilityModifierForScore3IsNegative4() {
    Assertions.assertEquals(-4, dnDCharacter.modifier(3));
  }

  @Test
  public void testAbilityModifierForScore4IsNegative3() {
    Assertions.assertEquals(-3, dnDCharacter.modifier(4));
  }

  @Test
  public void testAbilityModifierForScore5IsNegative3() {
    Assertions.assertEquals(-3, dnDCharacter.modifier(5));
  }

  @Test
  public void testAbilityModifierForScore6IsNegative2() {
    Assertions.assertEquals(-2, dnDCharacter.modifier(6));
  }

  @Test
  public void testAbilityModifierForScore7IsNegative2() {
    Assertions.assertEquals(-2, dnDCharacter.modifier(7));
  }

  @Test
  public void testAbilityModifierForScore8IsNegative1() {
    Assertions.assertEquals(-1, dnDCharacter.modifier(8));
  }

  @Test
  public void testAbilityModifierForScore9IsNegative1() {
    Assertions.assertEquals(-1, dnDCharacter.modifier(9));
  }

  @Test
  public void testAbilityModifierForScore10Is0() {
    Assertions.assertEquals(0, dnDCharacter.modifier(10));
  }

  @Test
  public void testAbilityModifierForScore11Is0() {
    Assertions.assertEquals(0, dnDCharacter.modifier(11));
  }

  @Test
  public void testAbilityModifierForScore12Is1() {
    Assertions.assertEquals(1, dnDCharacter.modifier(12));
  }

  @Test
  public void testAbilityModifierForScore13Is1() {
    Assertions.assertEquals(1, dnDCharacter.modifier(13));
  }

  @Test
  public void testAbilityModifierForScore14Is2() {
    Assertions.assertEquals(2, dnDCharacter.modifier(14));
  }

  @Test
  public void testAbilityModifierForScore15Is2() {
    Assertions.assertEquals(2, dnDCharacter.modifier(15));
  }

  @Test
  public void testAbilityModifierForScore16Is3() {
    Assertions.assertEquals(3, dnDCharacter.modifier(16));
  }

  @Test
  public void testAbilityModifierForScore17Is3() {
    Assertions.assertEquals(3, dnDCharacter.modifier(17));
  }

  @Test
  public void testAbilityModifierForScore18Is4() {
    Assertions.assertEquals(4, dnDCharacter.modifier(18));
  }

  @Test
  public void test4DiceWereUsedForRollingScores() {
    Assertions.assertEquals(4, dnDCharacter.rollDice().size());
  }

  @Test
  public void testDiceValuesBetween1And6() {
    assertThat(dnDCharacter.rollDice()).allMatch(d -> d >= 1 && d <= 6);
  }

  @Test
  public void testAbilityCalculationsUses3LargestNumbersFromScoresInDescendingOrder() {
    assertThat(dnDCharacter.ability(List.of(4, 3, 2, 1))).isEqualTo(9);
  }

  @Test
  public void testAbilityCalculationsUses3LargestNumbersFromFromScoresInAscendingOrder() {
    assertThat(dnDCharacter.ability(List.of(1, 2, 3, 4))).isEqualTo(9);
  }

  @Test
  public void testAbilityCalculationsUses3LargestNumbersFromScoresInRandomOrder() {
    assertThat(dnDCharacter.ability(List.of(2, 4, 3, 1))).isEqualTo(9);
  }

  @Test
  public void testAbilityCalculationsWithLowestEqualNumbers() {
    assertThat(dnDCharacter.ability(List.of(1, 1, 1, 1))).isEqualTo(3);
  }

  @Test
  public void testAbilityCalculationsWithHighestEqualNumbers() {
    assertThat(dnDCharacter.ability(List.of(6, 6, 6, 6))).isEqualTo(18);
  }

  @Test
  public void testAbilityCalculationDoesNotChangeInputScores() {
    List<Integer> scores = List.of(1, 2, 3, 4);
    dnDCharacter.ability(scores);
    assertThat(scores.size()).isEqualTo(4);
    assertThat(scores).containsExactly(1, 2, 3, 4);
  }

  @Test
  public void testRandomCharacterIsValid() {
    for (int i = 0; i < 1000; i++) {
      DnDCharacter character = new DnDCharacter();
      assertThat(character.getStrength()).isGreaterThan(2).isLessThan(19);
      assertThat(character.getDexterity()).isGreaterThan(2).isLessThan(19);
      assertThat(character.getConstitution()).isGreaterThan(2).isLessThan(19);
      assertThat(character.getIntelligence()).isGreaterThan(2).isLessThan(19);
      assertThat(character.getWisdom()).isGreaterThan(2).isLessThan(19);
      assertThat(character.getCharisma()).isGreaterThan(2).isLessThan(19);
      assertThat(character.getHitpoints()).isEqualTo(10 + character.modifier(character.getConstitution()));
    }
  }

  @Test
  public void testEachAbilityIsOnlyCalculatedOnce() {
    assertThat(dnDCharacter.getStrength()).isEqualTo(dnDCharacter.getStrength());
    assertThat(dnDCharacter.getDexterity()).isEqualTo(dnDCharacter.getDexterity());
    assertThat(dnDCharacter.getConstitution()).isEqualTo(dnDCharacter.getConstitution());
    assertThat(dnDCharacter.getIntelligence()).isEqualTo(dnDCharacter.getIntelligence());
    assertThat(dnDCharacter.getWisdom()).isEqualTo(dnDCharacter.getWisdom());
    assertThat(dnDCharacter.getCharisma()).isEqualTo(dnDCharacter.getCharisma());
  }

  @Test
  public void testUniqueCharacterIsCreated() {
    DnDCharacter uniqueDnDCharacter = new DnDCharacter();
    for (int i = 0; i < 1000; i++) {
      DnDCharacter dnDCharacter = new DnDCharacter();
      boolean dnDCharactersHaveDifferentAttributes = dnDCharacter.getStrength() != uniqueDnDCharacter.getStrength() || dnDCharacter.getDexterity() != uniqueDnDCharacter.getDexterity() || dnDCharacter.getConstitution() != uniqueDnDCharacter.getConstitution() || dnDCharacter.getIntelligence() != uniqueDnDCharacter.getIntelligence() || dnDCharacter.getWisdom() != uniqueDnDCharacter.getWisdom() || dnDCharacter.getCharisma() != uniqueDnDCharacter.getCharisma() || dnDCharacter.getHitpoints() != uniqueDnDCharacter.getHitpoints();
      Assertions.assertTrue(dnDCharactersHaveDifferentAttributes);
    }
  }
}