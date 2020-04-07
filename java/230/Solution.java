public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        while (root != null) {
            int leftCount = countNodes(root.left);
            if (leftCount > k - 1) {
                root = root.left;
            } else if (leftCount < k - 1) {
                root = root.right;
                k -= leftCount + 1;
            } else {
                return root.val;
            }
        }
        return 0;
    }
    
    private int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
