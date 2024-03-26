package org.khiemtran.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamCreation {
  public Stream<String> createEmptyStream() {
    return Stream.empty();
  }

  public Stream<String>createCollectionStream() {
    Collection<String> collection  = Arrays.asList("a", "b", "c");
    Stream<String> stream = collection.stream();
    return stream;
  }
}
