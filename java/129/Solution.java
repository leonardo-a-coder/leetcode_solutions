public class Solution {
    private int sum;
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbers(root, 0);
        return sum;
    }
    
    private void sumNumbers(TreeNode root, int cur) {
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }
        if (root.left != null) {
            sumNumbers(root.left, cur);
        }
        if (root.right != null) {
            sumNumbers(root.right, cur);
        }
    }
}
