public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        binaryTreePaths(root, result, new StringBuilder());
        return result;
    }
    
    private void binaryTreePaths(TreeNode root, List<String> result, StringBuilder sb) {
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            sb.setLength(len);
            return;
        }
        sb.append("->");
        if (root.left != null) {
            binaryTreePaths(root.left, result, sb);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, result, sb);
        }
        sb.setLength(len);
    }
}
