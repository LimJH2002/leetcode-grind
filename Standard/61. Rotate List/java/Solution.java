import java.util.ArrayDeque;
import java.util.Deque;

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
    public ListNode rotateRight(ListNode head, int k) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }

        if (deque.isEmpty()) {
            return head;
        }

        k = k % deque.size();

        for (int i = 0; i < k; i++) {
            ListNode tail = deque.removeLast();
            tail.next = deque.peekFirst();
            deque.addFirst(tail);
            deque.peekLast().next = null;
        }

        return deque.peekFirst();
    }
}