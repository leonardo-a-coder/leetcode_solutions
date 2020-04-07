public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || k == 0) {
            return result;
        }
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> sucStack = new Stack<>();
        
        initPreStack(root, preStack, target);
        initSucStack(root, sucStack, target);
        if (!preStack.isEmpty() && !sucStack.isEmpty() && preStack.peek().val == sucStack.peek().val) {
            getNextSuc(sucStack);
        }
        while (k-- > 0) {
            if (preStack.isEmpty()) {
                result.add(sucStack.peek().val);
                getNextSuc(sucStack);
            } else if (sucStack.isEmpty()) {
                result.add(preStack.peek().val);
                getNextPre(preStack);
            } else if (Math.abs(preStack.peek().val - target) <= Math.abs(sucStack.peek().val - target)) {
                result.add(preStack.peek().val);
                getNextPre(preStack);
            } else {
                result.add(sucStack.peek().val);
                getNextSuc(sucStack);
            }
        }
        return result;
    }
    
    private void initPreStack(TreeNode root, Stack<TreeNode> stack, double target) {
        while (root != null) {
            if (root.val < target) {
                stack.push(root);
                root = root.right;
            } else if (root.val > target) {
                root = root.left;
            } else {
                stack.push(root);
                return;
            }
        }
    }
    
    private void initSucStack(TreeNode root, Stack<TreeNode> stack, double target) {
        while (root != null) {
            if (root.val < target) {
                root = root.right;
            } else if (root.val > target) {
                stack.push(root);
                root = root.left;
            } else {
                stack.push(root);
                return;
            }
        }
    }
    
    private void getNextPre(Stack<TreeNode> stack) {
        TreeNode cur = stack.pop().left;
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
    }
    
    private void getNextSuc(Stack<TreeNode> stack) {
        TreeNode cur = stack.pop().right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
