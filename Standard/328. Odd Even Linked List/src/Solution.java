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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastOdd = head;
        ListNode lastEven = head.next;
        ListNode firstEven = head.next;
        ListNode current = lastEven.next;
        int sequence = 3;

        while (current != null) {
            if (sequence % 2 == 0) {
                lastOdd.next = firstEven;
                lastEven.next = current;
                lastEven = current;
            } else {
                lastOdd.next = current;
                lastOdd = current;
            }

            sequence++;
            current = current.next;
        }

        lastOdd.next = firstEven;
        lastEven.next = null;
        return head;
    }   
}