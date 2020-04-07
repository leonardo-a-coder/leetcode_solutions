public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= min && root.val <= max) {
            return isValidBST(root.left, min, (long) root.val - 1) && isValidBST(root.right, (long) root.val + 1, max);
        } else {
            return false;
        }
    }
}
