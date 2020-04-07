public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] result = new int[1];
        longestConsecutive(root, result);
        return result[0];
    }
    
    private int longestConsecutive(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int path = 0;
        int left = longestConsecutive(root.left, result);
        int right = longestConsecutive(root.right, result);
        if (root.left != null && root.val + 1 == root.left.val) {
            path = left;
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            path = Math.max(path, right);
        }
        result[0] = Math.max(result[0], path + 1);
        return path + 1;
    }
}
