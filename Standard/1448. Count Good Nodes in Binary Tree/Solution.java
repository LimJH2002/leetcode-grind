/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    public int helper(TreeNode root, int max) {
        int count = root.val >= max ? 1 : 0;

        if (root.val > max) {
            max = root.val;
        }

        if (root.left != null) {
            count += helper(root.left, Math.max(max, root.val));
        }

        if (root.right != null) {
            count += helper(root.right, Math.max(max, root.val));
        }

        return count;
    }
}