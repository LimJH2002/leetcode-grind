import java.util.HashMap;

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
    public int pairSum(ListNode head) {
        ListNode current = head;
        int length = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentMax = 0;

        while (current != null) {
            map.put(length, current.val);
            current = current.next;
            length++;
        }

        length--;

        for (int i = 1; i <= length / 2; i++) {
            currentMax = Math.max(currentMax, map.get(i) + map.get(length - i + 1));
        }

        return currentMax;
    }
}