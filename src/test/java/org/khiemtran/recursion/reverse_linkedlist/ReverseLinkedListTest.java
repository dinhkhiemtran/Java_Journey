package org.khiemtran.recursion.reverse_linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListTest {
  private ReverseLinkedList reverseLinkedList;

  @BeforeEach
  public void setup() {
    reverseLinkedList = new ReverseLinkedList();
  }

  @Test
  public void testReverseListWithEmptyList() {
    // Create an empty list
    ListNode emptyList = null;
    // Reverse the list
    ListNode reversed = reverseLinkedList.reverseList(emptyList);
    // The reversed list should also be empty
    assertEquals(null, reversed);
  }

  @Test
  public void testReverseListWithSingleNode() {
    // Create a list with a single node (1)
    ListNode singleNode = new ListNode(1);
    // Reverse the list
    ListNode reversed = reverseLinkedList.reverseList(singleNode);
    // The reversed list should be the same as the original (1)
    assertEquals(singleNode, reversed);
  }

  @Test
  public void testReverseListWithMultipleNodes() {
    // Create a list: 1 -> 2 -> 3 -> null
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    // Reverse the list
    ListNode reversed = reverseLinkedList.reverseList(head);
    // The reversed list should be: 3 -> 2 -> 1 -> null
    assertEquals(3, reversed.val);
    assertEquals(2, reversed.next.val);
    assertEquals(1, reversed.next.next.val);
    assertEquals(null, reversed.next.next.next);
  }
}
