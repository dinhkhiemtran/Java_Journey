package org.khiemtran.switches;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProteinTranslatorTest {
  private ProteinTranslator proteinTranslator;

  @BeforeEach
  public void setUp() {
    proteinTranslator = new ProteinTranslator();
  }

  @Test
  public void testEmptyRnaSequenceResultInNoproteins() {
    assertThat(proteinTranslator.translate("")).isEmpty();
  }

  @Test
  public void testMethionineRnaSequence() {
    assertThat(proteinTranslator.translate("AUG")).containsExactly("Methionine");
  }

  @Test
  public void testPhenylalanineRnaSequence1() {
    assertThat(proteinTranslator.translate("UUU")).containsExactly("Phenylalanine");
  }

  @Test
  public void testPhenylalanineRnaSequence2() {
    assertThat(proteinTranslator.translate("UUC")).containsExactly("Phenylalanine");
  }

  @Test
  public void testLeucineRnaSequence1() {
    assertThat(proteinTranslator.translate("UUA")).containsExactly("Leucine");
  }

  @Test
  public void testLeucineRnaSequence2() {
    assertThat(proteinTranslator.translate("UUG")).containsExactly("Leucine");
  }

  @Test
  public void testSerineRnaSequence1() {
    assertThat(proteinTranslator.translate("UCU")).containsExactly("Serine");
  }

  @Test
  public void testSerineRnaSequence2() {
    assertThat(proteinTranslator.translate("UCC")).containsExactly("Serine");
  }

  @Test
  public void testSerineRnaSequence3() {
    assertThat(proteinTranslator.translate("UCA")).containsExactly("Serine");
  }

  @Test
  public void testSerineRnaSequence4() {
    assertThat(proteinTranslator.translate("UCG")).containsExactly("Serine");
  }

  @Test
  public void testTyrosineRnaSequence1() {
    assertThat(proteinTranslator.translate("UAU")).containsExactly("Tyrosine");
  }

  @Test
  public void testTyrosineRnaSequence2() {
    assertThat(proteinTranslator.translate("UAC")).containsExactly("Tyrosine");
  }

  @Test
  public void testCysteineRnaSequence1() {
    assertThat(proteinTranslator.translate("UGU")).containsExactly("Cysteine");
  }

  @Test
  public void testCysteineRnaSequence2() {
    assertThat(proteinTranslator.translate("UGC")).containsExactly("Cysteine");
  }

  @Test
  public void testTryptophanRnaSequence1() {
    assertThat(proteinTranslator.translate("UGG")).containsExactly("Tryptophan");
  }

  @Test
  public void testStopRnaSequence1() {
    assertThat(proteinTranslator.translate("UAA")).isEmpty();
  }

  @Test
  public void testStopRnaSequence2() {
    assertEquals(List.of(), proteinTranslator.translate("UAG"));
  }

  @Test
  public void testStopRnaSequence3() {
    assertEquals(List.of(), proteinTranslator.translate("UGA"));
  }

  @Test
  public void testSequenceOfTwoProteinCodonsTranslatesIntoProteins() {
    assertEquals(List.of("Phenylalanine", "Phenylalanine"),
        proteinTranslator.translate("UUUUUU"));
  }

  @Test
  public void testSequenceOfTwoDifferentProteinCodonsTranslatesIntoProteins() {
    assertEquals(List.of("Leucine", "Leucine"),
        proteinTranslator.translate("UUAUUG"));
  }

  @Test
  public void testTranslationOfRnaToProteinList() {
    assertEquals(List.of("Methionine", "Phenylalanine", "Tryptophan"),
        proteinTranslator.translate("AUGUUUUGG"));
  }

  @Test
  public void testTranslationStopsIfStopCodonAtBeginning() {
    assertEquals(List.of(),
        proteinTranslator.translate("UAGUGG"));
  }

  @Test
  public void testTranslationStopsIfStopCodonAtEnd2() {
    assertEquals(List.of("Methionine", "Phenylalanine"),
        proteinTranslator.translate("AUGUUUUAA"));
  }

  @Test
  public void testTranslationStopsIfStopCodonInMiddle1() {
    assertEquals(List.of("Tryptophan"),
        proteinTranslator.translate("UGGUAGUGG"));
  }

  @Test
  public void testTranslationStopsIfStopCodonInMiddle2() {
    assertEquals(List.of("Tryptophan", "Cysteine", "Tyrosine"),
        proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"));
  }

  @Test
  public void testNonExistingCodonCantTranslate() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> proteinTranslator.translate("AAA"));
    assertEquals("Invalid codon", exception.getMessage());
  }

  @Test
  public void testUnknownAminoAcidsNotPartOfACodonCantTranslate() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> proteinTranslator.translate("XYZ"));
    assertEquals("Invalid codon", exception.getMessage());
  }

  @Test
  public void testIncompleteRnaSequenceCantTranslate() {
    Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> proteinTranslator.translate("AUGU"));
    assertEquals("Invalid codon", exception.getMessage());
  }

  @Test
  public void testIncompleteRnaSequenceCanTranslateIfValidUntilAStopCodon() {
    assertEquals(List.of("Phenylalanine", "Phenylalanine"),
        proteinTranslator.translate("UUCUUCUAAUGGU"));
  }
}