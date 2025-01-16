import java.util.List;
import java.util.Stack;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        } else {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
    }

    ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        for (int i = 0; i < n; i++) {
            stack.push(curr);
            curr = curr.next;
        }

        successor = curr;

        ListNode newHead = stack.pop();
        curr = newHead;

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        curr.next = successor;

        return newHead;
    }
}