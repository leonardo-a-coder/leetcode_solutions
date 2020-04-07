public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null;
        TreeNode right = null;
        while (root != null) {
            TreeNode curLeft = root.left;
            TreeNode curRight = root.right;
            root.left = right;
            root.right = parent;
            parent = root;
            right = curRight;
            root = curLeft;
        }
        return parent;
    }
}
