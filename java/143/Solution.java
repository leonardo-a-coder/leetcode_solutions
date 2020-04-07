public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        secondHead = reverse(secondHead);
        merge(head, secondHead);
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (node1 != null && node2 != null) {
            cur.next = node1;
            node1 = node1.next;
            cur.next.next = node2;
            node2 = node2.next;
            cur = cur.next.next;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        return result.next;
    }
}
