package org.khiemtran.basics.wizards_and_warriors_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameMasterTest {
  @Test
  public void testDescribeCharacter() {
    Character character = new Character();
    character.setCharacterClass("Wizard");
    character.setLevel(4);
    character.setHitPoints(28);
    String expect = "You're a level 4 Wizard with 28 hit points.";
    Assertions.assertEquals(expect,
        new GameMaster().describe(character));
  }

  @Test
  public void testDescribeDestination() {
    Destination destination = new Destination();
    destination.setName("Muros");
    destination.setInhabitants(732);
    String expect = "You've arrived at Muros, which has 732 inhabitants.";
    Assertions.assertEquals(expect, new GameMaster().describe(destination));
  }

  @Test
  public void testDescribeTravelMethod() {
    Assertions.assertEquals("You're traveling to your destination on horseback.",
        new GameMaster().describe(TravelMethod.HORSEBACK));
  }

  @Test
  public void testDescribeTravelCharacterAndDestinationAndTravelMethod() {
    Character character = new Character();
    character.setCharacterClass("Wizard");
    character.setLevel(4);
    character.setHitPoints(28);
    Destination destination = new Destination();
    destination.setName("Muros");
    destination.setInhabitants(732);
    String expect = "You're a level 4 Wizard with 28 hit points. You're traveling to your destination on horseback. You've arrived at Muros, which has 732 inhabitants.";
    Assertions.assertEquals(expect, new GameMaster().describe(
        character, destination, TravelMethod.HORSEBACK));
  }

  @Test
  public void testDescribeCharacterAndDestination() {
    Character character = new Character();
    character.setCharacterClass("Wizard");
    character.setLevel(4);
    character.setHitPoints(28);
    Destination destination = new Destination();
    destination.setInhabitants(732);
    destination.setName("Muros");
    String expect = "You're a level 4 Wizard with 28 hit points. You're traveling to your destination by walking. You've arrived at Muros, which has 732 inhabitants.";
    Assertions.assertEquals(expect, new GameMaster().describe(character, destination));
  }

  @Test
  @Tag("task:1")
  @DisplayName("Describe a character by class: Warrior")
  public void describeWarriorCharacter() {
    Character character = new Character();
    character.setCharacterClass("Warrior");
    character.setLevel(16);
    character.setHitPoints(89);
    assertThat(new GameMaster().describe(character)).isEqualTo("You're a level 16 Warrior with 89 hit points" + ".");
  }

  @Test
  @Tag("task:1")
  @DisplayName("Describe a character by class: Wizard")
  public void describeWizardCharacter() {
    Character character = new Character();
    character.setCharacterClass("Wizard");
    character.setLevel(7);
    character.setHitPoints(33);
    assertThat(new GameMaster().describe(character)).isEqualTo("You're a level 7 Wizard with 33 hit points.");
  }

  @Test
  @Tag("task:2")
  @DisplayName("Describe a destination: Tol Honeth")
  public void describeSmallTownDestination() {
    Destination destination = new Destination();
    destination.setName("Tol Honeth");
    destination.setInhabitants(41);
    assertThat(new GameMaster().describe(destination)).isEqualTo("You've arrived at Tol Honeth, which has 41" + " inhabitants.");
  }

  @Test
  @Tag("task:2")
  @DisplayName("Describe a destination: Ashaba")
  public void describeLargeTownDestination() {
    Destination destination = new Destination();
    destination.setName("Ashaba");
    destination.setInhabitants(1500);
    assertThat(new GameMaster().describe(destination)).isEqualTo("You've arrived at Ashaba, which has 1500 " + "inhabitants.");
  }

  @Test
  @Tag("task:3")
  @DisplayName("Describe the travel method: walking")
  public void describeWalkingTravelMethod() {
    assertThat(new GameMaster().describe(TravelMethod.WALKING)).isEqualTo("You're traveling to your " + "destination by walking.");
  }

  @Test
  @Tag("task:3")
  @DisplayName("Describe the travel method: horseback")
  public void describeHorseTravelMethod() {
    assertThat(new GameMaster().describe(TravelMethod.HORSEBACK)).isEqualTo("You're traveling to your " + "destination on horseback.");
  }

  @Test
  @Tag("task:4")
  @DisplayName("Describe a character traveling to a destination")
  public void describeCharacterTravelingToDestinationWithExplicitTravelMethod() {
    Character character = new Character();
    character.setCharacterClass("Wizard");
    character.setLevel(20);
    character.setHitPoints(120);
    Destination destination = new Destination();
    destination.setName("Camaar");
    destination.setInhabitants(999);
    assertThat(new GameMaster().describe(character, destination, TravelMethod.HORSEBACK)).isEqualTo("You're a level 20 Wizard with 120 hit points. You're traveling to your destination on horseback. " + "You've arrived at Camaar, which has 999 inhabitants.");
  }

  @Test
  @Tag("task:5")
  @DisplayName("Combined description should handle character and destination with default travel method")
  public void describeCharacterTravelingToDestinationWithoutExplicitTravelMethod() {
    Character character = new Character();
    character.setCharacterClass("Warrior");
    character.setLevel(1);
    character.setHitPoints(30);
    Destination destination = new Destination();
    destination.setName("Vo Mimbre");
    destination.setInhabitants(332);
    Assertions.assertEquals("You're a level 1 Warrior with 30 hit points. You're traveling to your destination by walking. You've"
            + " arrived at Vo Mimbre, which has 332 inhabitants."
        , new GameMaster().describe(character, destination));
  }
}