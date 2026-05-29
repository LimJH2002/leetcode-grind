import java.util.ArrayList;
import java.util.List;

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
class SolutionDFS {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverseHelper(root, 0);
        return result;
    }

    private void traverseHelper(TreeNode node, int index) {
        if (node == null) {
            return;
        }

        if (result.size() <= index) {
            List<Integer> level = new ArrayList<>();
            level.add(node.val);
            result.add(level);
        } else {
            result.get(index).add(node.val);
        }

        traverseHelper(node.left, index + 1);
        traverseHelper(node.right, index + 1);
    }
}