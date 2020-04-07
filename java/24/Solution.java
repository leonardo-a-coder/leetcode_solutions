public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode next1 = cur.next;
            ListNode next2 = cur.next.next;
            ListNode next3 = next2.next;
            next2.next = cur.next;
            next1.next = next3;
            cur.next = next2;
            cur = next1;
        }
        return fakeHead.next;
    }
}
