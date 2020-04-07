public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>((int) (inorder.length / 0.75 + 1));
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderMap);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postEnd]);
        int inMid = inorderMap.get(postorder[postEnd]);
        cur.left = buildTree(inorder, postorder, inStart, inMid - 1, postStart, postStart + inMid - inStart - 1, inorderMap);
        cur.right = buildTree(inorder, postorder, inMid + 1, inEnd, postStart + inMid - inStart, postEnd - 1, inorderMap);
        return cur;
    }
}
