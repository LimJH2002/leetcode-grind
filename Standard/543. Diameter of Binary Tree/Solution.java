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
    public int diameterOfBinaryTree(TreeNode root) {
        // Diameter of a tree is the maximum of the following three:
        // 1. Diameter of the left subtree
        // 2. Diameter of the right subtree
        // 3. Longest path between two nodes that passes through the root

        // Base case
        if (root == null) {
            return 0;
        }

        // Calculate the diameter of the left and right subtrees
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        // Calculate the longest path between two nodes that passes through the root
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int totalHeight = leftHeight + rightHeight;

        // Return the maximum of the three
        return Math.max(totalHeight, Math.max(leftDiameter, rightDiameter));
    }

    private int height(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Return the maximum of the two heights plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}