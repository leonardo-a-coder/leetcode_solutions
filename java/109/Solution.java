public class Solution {
    private ListNode node;
    
    public TreeNode sortedListToBST(ListNode head) {
        int len = getLength(head);
        node = head;
        return sortedListToBST(0, len - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = sortedListToBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
