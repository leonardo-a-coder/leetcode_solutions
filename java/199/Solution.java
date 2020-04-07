public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }
    
    private void rightSideView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(root.val);
        } else {
            result.set(depth, root.val);
        }
        rightSideView(root.left, result, depth + 1);
        rightSideView(root.right, result, depth + 1);
    }
}
