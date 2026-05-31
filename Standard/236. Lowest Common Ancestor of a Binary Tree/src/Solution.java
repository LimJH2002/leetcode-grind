/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if (node == p || node == q) {
            return node;
        }

        TreeNode leftResult = lowestCommonAncestor(node.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(node.right, p, q);

        if (leftResult != null && rightResult != null) {
            return node;
        } else if (leftResult != null) {
            return leftResult;
        } else {
            return rightResult;
        }
    }
}