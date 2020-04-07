public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= q.val) {
            return lca(root, p, q);
        } else {
            return lca(root, q, p);
        }
    }
    
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root == p || root == q) {
            return root;
        }
        if (q.val < root.val) {
            return lca(root.left, p, q);
        } else if (p.val > root.val) {
            return lca(root.right, p, q);
        } else if (p.val < root.val && q.val > root.val) {
            return root;
        } else {
            TreeNode left = lca(root.left, p, q);
            TreeNode right = lca(root.right, p, q);
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                return root;
            }
        }
    }
}
