public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        while (root.left != null) {
            int leftDepth = countLeftDepth(root.left);
            int rightDepth = countLeftDepth(root.right);
            if (leftDepth == rightDepth) {
                result = (result << 1) + 1;
                root = root.right;
            } else {
                result <<= 1;
                root = root.left;
            }
        }
        return result;
    }
    
    private int countLeftDepth(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }
}
