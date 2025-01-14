/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode ptr1 = head;
    ListNode ptr2 = head;

    while (ptr1 != null || ptr2 != null) {
      ptr1 = ptr1.next;
      if (ptr2 != null && ptr2.next != null) {
        ptr2 = ptr2.next.next;
      } else {
        return false;
      }

      if (ptr1 == ptr2) {
        return true;
      }
    }

    return false;
  }
}