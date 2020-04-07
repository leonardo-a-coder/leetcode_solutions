public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        int result = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - result)) {
                result = root.val;
            }
            if (root.val > target) {
                root = root.left;
            } else if (root.val < target) {
                root = root.right;
            } else {
                return root.val;
            }
        }
        return result;
    }
}
