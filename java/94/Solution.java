public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return result;
    }
}
