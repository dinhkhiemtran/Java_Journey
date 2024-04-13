package org.khiemtran.maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RnaTranscriptionTest {
  private RnaTranscription rnaTranscription;

  @BeforeEach
  public void setup() {
    rnaTranscription = new RnaTranscription();
  }

  @Test
  public void testEmptyRnaSequence() {
    Assertions.assertEquals("",
        rnaTranscription.transcribe(""));
  }

  @Test
  public void testRnaTranscriptionOfCytosineIsGuanine() {
    Assertions.assertEquals("G",
        rnaTranscription.transcribe("C"));
  }

  @Test
  public void testRnaTranscriptionOfGuanineIsCytosine() {
    Assertions.assertEquals("C",
        rnaTranscription.transcribe("G"));
  }

  @Test
  public void testRnaTranscriptionOfThymineIsAdenine() {
    Assertions.assertEquals("A",
        rnaTranscription.transcribe("T"));
  }

  @Test
  public void testRnaTranscriptionOfAdenineIsUracil() {
    Assertions.assertEquals("U",
        rnaTranscription.transcribe("A"));
  }

  @Test
  public void testRnaTranscription() {
    Assertions.assertEquals("UGCACCAGAAUU",
        rnaTranscription.transcribe("ACGTGGTCTTAA"));
  }
}