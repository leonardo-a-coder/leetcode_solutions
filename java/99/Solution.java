public class Solution {
    private TreeNode err1;
    private TreeNode err2;
    private TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        if (err1 != null) {
            swap(err1, err2);
        }
    }
    
    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        if (prev != null && prev.val >= root.val) {
            if (err1 == null) {
                err1 = prev;
            }
            err2 = root;
        }
        prev = root;
        inorderTraverse(root.right);
    }
    
    private void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
