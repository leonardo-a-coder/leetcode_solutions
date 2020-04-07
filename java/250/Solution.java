public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        count(root, result);
        return result[0];
    }
    
    private Integer count(TreeNode root, int[] result) {
        Integer left = root.left == null ? Integer.valueOf(root.val) : count(root.left, result);
        Integer right = root.right == null ? Integer.valueOf(root.val) : count(root.right, result);
        if (left == null || left != root.val || right == null || right != root.val) {
            return null;
        } else {
            result[0]++;
            return root.val;
        }
    }
}
