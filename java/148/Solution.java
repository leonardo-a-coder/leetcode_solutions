public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        head = sortList(head);
        secondHead = sortList(secondHead);
        return merge(head, secondHead);
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }
        while (node1 != null) {
            cur.next = node1;
            cur = cur.next;
            node1 = node1.next;
        }
        while (node2 != null) {
            cur.next = node2;
            cur = cur.next;
            node2 = node2.next;
        }
        return result.next;
    }
}
