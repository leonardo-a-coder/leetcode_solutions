public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = getLength(head);
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        if (right == null) {
            return head;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        ListNode ret = left.next;
        left.next = null;
        right.next = head;
        return ret;
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
