public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode nextStart = null;
        while (root.left != null) {
            nextStart = root.left;
            while (root.next != null) {
                root.left.next = root.right;
                root.right.next = root.next.left;
                root = root.next;
            }
            root.left.next = root.right;
            root = nextStart;
        }
    }
}
