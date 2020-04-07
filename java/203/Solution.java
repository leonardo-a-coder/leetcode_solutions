public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return fakeHead.next;
    }
}
