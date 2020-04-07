public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        while (cur != null) {
            ListNode nextHead = cur.next;
            ListNode nextTail = cur;
            for (int i = 0; i < k; i++) {
                nextTail = nextTail.next;
                if (nextTail == null) {
                    return fakeHead.next;
                }
            }
            ListNode nextNextHead = nextTail.next;
            cur.next = null;
            nextTail.next = null;
            cur.next = reverse(nextHead);
            nextHead.next = nextNextHead;
            cur = nextHead;
        }
        return fakeHead.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
