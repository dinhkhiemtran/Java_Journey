package org.khiemtran.objects.wizards_and_warriors_2;

public class GameMaster {
  private static final String CHARACTER_DESCRIBE = "You're a level %d %s with %s hit points.";
  private static final String DESTINATION_DESCRIBE = "You've arrived at %s, which has %d inhabitants.";
  private static final String TRAVEL_METHOD_DESCRIBE = "You're traveling to your destination %s %s.";

  public String describe(Character character) {
    return String.format(CHARACTER_DESCRIBE, character.getLevel(),
        character.getCharacterClass(),
        character.getHitPoints());
  }

  public String describe(Destination destination) {
    return String.format(DESTINATION_DESCRIBE,
        destination.getName(),
        destination.getInhabitants());
  }

  public String describe(TravelMethod travelMethod) {
    return String.format(TRAVEL_METHOD_DESCRIBE,
        switch (travelMethod) {
          case HORSEBACK -> "on";
          case WALKING -> "by";
        },
        travelMethod.getValue());
  }

  public String describe(Character character, Destination destination, TravelMethod travelMethod) {
    return new StringBuilder().append(describe(character))
        .append(" " + describe(travelMethod))
        .append(" " + describe(destination)).toString();
  }

  public String describe(Character character, Destination destination) {
    return new StringBuilder().append(describe(character))
        .append(" " + describe(TravelMethod.WALKING))
        .append(" " + describe(destination)).toString();
  }
}
