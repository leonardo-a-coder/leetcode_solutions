public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preStart]);
        int inMid = inorderMap.get(preorder[preStart]);
        cur.left = buildTree(preorder, inorder, preStart + 1, preStart + inMid - inStart, inStart, inMid - 1, inorderMap);
        cur.right = buildTree(preorder, inorder, preStart + inMid - inStart + 1, preEnd, inMid + 1, inEnd, inorderMap);
        return cur;
    }
}
