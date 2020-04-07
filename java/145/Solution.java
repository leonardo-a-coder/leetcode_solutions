public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                cur = cur.right;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
