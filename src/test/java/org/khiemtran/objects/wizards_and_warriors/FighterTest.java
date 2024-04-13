package org.khiemtran.objects.wizards_and_warriors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FighterTest {
  @Test
  @Tag("task:2")
  @DisplayName("The toString method of the Warrior returns the correct description of the fighter")
  void testWarriorToString() {
    assertThat(new Warrior().toString()).isEqualTo("Fighter is a Warrior");
  }

  @Test
  @Tag("task:3")
  @DisplayName("A Warrior is never vulnerable")
  void testWarriorAlwaysInvulnerable() {
    assertThat(new Warrior().isVulnerable()).isFalse();
  }

  @Test
  @Tag("task:6")
  @DisplayName("The toString method of the Wizard returns the correct description of the fighter")
  void testWizardToString() {
    assertThat(new Wizard().toString()).isEqualTo("Fighter is a Wizard");
  }

  @Test
  @Tag("task:7")
  @DisplayName("A Wizard is vulnerable when not prepared with a spell")
  void testWizardVulnerableByDefault() {
    assertThat(new Wizard().isVulnerable()).isTrue();
  }

  @Test
  @Tag("task:8")
  @DisplayName("A Wizard deals 3 damage when no spell has been prepared")
  void testWizardsDamagePoints() {
    assertThat(new Wizard().getDamagePoints(new Fighter())).isEqualTo(3);
  }
}
