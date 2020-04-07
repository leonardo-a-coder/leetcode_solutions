public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            while (cur != null) {
                result.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.left;
            }
        }
        return result;
    }
}
