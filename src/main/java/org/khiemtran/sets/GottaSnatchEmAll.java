package org.khiemtran.sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GottaSnatchEmAll {
  static Set<String> newCollection(List<String> cards) {
    return new HashSet<>(cards);
  }

  static boolean addCard(String card, Set<String> collection) {
    return collection.add(card);
  }

  static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
    return !isEmpty(myCollection, theirCollection) && myCollection.addAll(theirCollection);
  }

  private static boolean isEmpty(Set<String> myCollection, Set<String> theirCollection) {
    return theirCollection.isEmpty() || myCollection.isEmpty();
  }

  static Set<String> commonCards(List<Set<String>> collections) {
    return collections.stream()
        .reduce((set1, set2) -> {
          Set<String> common = new HashSet<>(set1);
          common.retainAll(set2);
          return common;
        }).orElse(new HashSet<>());
  }

  static Set<String> allCards(List<Set<String>> collections) {
    return collections.stream()
        .flatMap(Set::stream)
        .collect(Collectors.toSet());
  }
}