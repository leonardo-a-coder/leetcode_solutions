public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = fakeHead;
        while (head != null) {
            boolean isDuplicate = false;
            while (head.next != null && head.next.val == head.val) {
                isDuplicate = true;
                head = head.next;
            }
            if (isDuplicate) {
                cur.next = head.next;
            } else {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        return fakeHead.next;
    }
}
