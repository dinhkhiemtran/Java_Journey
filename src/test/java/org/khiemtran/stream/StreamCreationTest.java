package org.khiemtran.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamCreationTest {
  @Test
  public void testCreateCollection() {
    Assertions.assertEquals("a",
        new StreamCreation().createCollectionStream());
  }
}