class Solution {
    public int maxDepth(TreeNode root) {
        return helperDepth(root, 0);
    }

    public int helperDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        } else {
            depth++;
            return Math.max(helperDepth(root.left, depth), helperDepth(root.right, depth));
        }
    }
}