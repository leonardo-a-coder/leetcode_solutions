public class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    
    private TreeNode flatten(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = flatten(root.right, prev);
        prev = flatten(root.left, prev);
        root.right = prev;
        root.left = null;
        return root;
    }
}
