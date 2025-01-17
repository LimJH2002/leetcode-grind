import java.util.Stack;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode counter = head;
        int count = 0;
        while (count < k && counter != null) {
            counter = counter.next;
            count++;
        }

        if (count < k) return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            stack.push(curr);
            curr = curr.next;
        }

        head = stack.pop();
        curr = head;

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }

        curr.next = reverseKGroup(counter, k);

        return head;
    }
}