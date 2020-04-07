public class Codec {
    private static final String DELIMITER = ",";
    private static final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(NULL).append(DELIMITER);
            } else {
                sb.append(cur.val).append(DELIMITER);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(DELIMITER);
        Queue<TreeNode> queue = new LinkedList<>();
        if (tokens.length == 0 || tokens[0].equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        queue.add(root);
        int index = 1;
        while (index < tokens.length) {
            TreeNode cur = queue.poll();
            String str = tokens[index++];
            if (!str.equals(NULL)) {
                TreeNode left = new TreeNode(Integer.parseInt(str));
                cur.left = left;
                queue.add(left);
            }
            str = tokens[index++];
            if (!str.equals(NULL)) {
                TreeNode right = new TreeNode(Integer.parseInt(str));
                cur.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
