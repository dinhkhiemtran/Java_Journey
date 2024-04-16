package org.khiemtran.switches;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProteinTranslator {
  private static final int CODON_SIZE = 3;

  List<String> translate(String rnaSequence) {
    return Stream.iterate(0, i -> i < rnaSequence.length(), i -> i + CODON_SIZE)
        .map(i -> rnaSequence.substring(i, Math.min(rnaSequence.length(), i + CODON_SIZE)))
        .map(this::getProteins)
        .takeWhile(codon -> !codon.equals("STOP"))
        .collect(Collectors.toList());
  }

  private String getProteins(String codon) {
    return switch (codon) {
      case "AUG" -> "Methionine";
      case "UUU", "UUC" -> "Phenylalanine";
      case "UUA", "UUG" -> "Leucine";
      case "UCU", "UCC", "UCA", "UCG" -> "Serine";
      case "UAU", "UAC" -> "Tyrosine";
      case "UGU", "UGC" -> "Cysteine";
      case "UGG" -> "Tryptophan";
      case "UAA", "UAG", "UGA" -> "STOP";
      default -> throw new IllegalArgumentException("Invalid codon");
    };
  }
}
