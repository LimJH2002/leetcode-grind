/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        newNode.random = copyRandomList(head.random);
        newNode.next = copyRandomList(head.next);

        return newNode;
    }
}