public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextHead = null;
        TreeLinkNode prev = null;
        while (root != null) {
            if (root.left != null) {
                if (nextHead == null) {
                    nextHead = root.left;
                }
                if (prev != null) {
                    prev.next = root.left;
                }
                prev = root.left;
            }
            if (root.right != null) {
                if (nextHead == null) {
                    nextHead = root.right;
                }
                if (prev != null) {
                    prev.next = root.right;
                }
                prev = root.right;
            }
            if (root.next != null) {
                root = root.next;
            } else {
                root = nextHead;
                nextHead = null;
                prev = null;
            }
        }
    }
}
