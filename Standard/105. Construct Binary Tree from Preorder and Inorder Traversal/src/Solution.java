import java.util.HashMap;

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
    HashMap<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1,
                                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootIndex = inorderIndex.get(preorder[preStart]);
        int leftTreeSize = rootIndex - inStart;

        TreeNode node = new TreeNode(preorder[preStart]);
        node.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize,
                                    inorder, inStart, rootIndex - 1);
        node.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd,
                                     inorder, rootIndex + 1, inEnd);

        return node;
    }
}