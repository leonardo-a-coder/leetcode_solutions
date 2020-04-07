public class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] result = new int[2];
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}
