public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        head = fakeHead;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode tail = head.next;
        for (int i = 0; i < n - m; i++) {
            ListNode next = tail.next;
            tail.next = next.next;
            next.next = head.next;
            head.next = next;
        }
        return fakeHead.next;
    }
}
