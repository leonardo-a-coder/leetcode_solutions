public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        maxPathSum(root, result);
        return result[0];
    }
    
    private int maxPathSum(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxPathSum(root.left, result);
        int rightMax = maxPathSum(root.right, result);
        result[0] = Math.max(result[0], root.val + Math.max(leftMax, 0) + Math.max(rightMax, 0));
        return root.val + Math.max(0, Math.max(leftMax, rightMax));
    }
}
