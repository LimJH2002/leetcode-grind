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
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();

        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            res.val = sum % 10;
            res.next = addTwoNumbers(l1.next, l2.next);
        } else if (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            res.val = sum % 10;
            res.next = addTwoNumbers(l1.next, null);
        } else if (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            res.val = sum % 10;
            res.next = addTwoNumbers(null, l2.next);
        } else {
            if (carry > 0) {
                res.val = carry;
                carry = 0;
                return res;
            }

            return null;
        }

        return res;
    }
}