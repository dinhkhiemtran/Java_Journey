package org.khiemtran.objects.wizards_and_warriors;

public class Wizard extends Fighter {
  boolean spellPrepared = false;

  @Override
  boolean isVulnerable() {
    return !spellPrepared;
  }

  @Override
  int getDamagePoints(Fighter fighter) {
    return spellPrepared ? 12 : 3;
  }

  public boolean prepareSpell() {
    return spellPrepared = true;
  }

  public String toString() {
    return String.format("Fighter is a %s", this.getClass().getSimpleName());
  }
}