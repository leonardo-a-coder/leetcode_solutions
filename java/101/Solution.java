public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        } else {
            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }
}
