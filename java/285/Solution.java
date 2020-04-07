public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            TreeNode parent = null;
            while (root != p) {
                if (root.val > p.val) {
                    parent = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return parent;
        }
    }
}
