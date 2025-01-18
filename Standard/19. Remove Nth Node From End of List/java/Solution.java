/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int diff = n;

        while (diff > 0) {
            fastPointer = fastPointer.next;
            diff--;
        }

        if (fastPointer == null) {
            return head.next;
        }

        while (fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }
}