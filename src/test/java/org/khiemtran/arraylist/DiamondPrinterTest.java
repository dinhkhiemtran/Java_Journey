package org.khiemtran.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiamondPrinterTest {
  private DiamondPrinter diamondPrinter;

  @BeforeEach
  public void setup() {
    diamondPrinter = new DiamondPrinter();
  }

  @Test
  public void testPrintToList() {
    diamondPrinter.printToList('c').forEach(System.out::println);
  }
}