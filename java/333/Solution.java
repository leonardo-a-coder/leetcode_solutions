public class Solution {
    private int maxSize;
    
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxSize;
    }
    
    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (left.size == -1 || right.size == -1 || (root.left != null && left.max >= root.val) || (root.right != null && right.min <= root.val)) {
            return new Result(-1);
        }
        int curSize = left.size + right.size + 1;
        maxSize = Math.max(maxSize, curSize);
        return new Result(root.left == null ? root.val : left.min, root.right == null ? root.val : right.max, curSize);
    }
    
    private class Result {
        private int min;
        private int max;
        private int size;
        
        Result(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
        Result(int size) {
            this(0, 0, size);
        }
    }
}
