public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode firstHead = new ListNode(0);
        ListNode firstCur = firstHead;
        ListNode secondHead = new ListNode(0);
        ListNode secondCur = secondHead;
        while (head != null) {
            if (head.val < x) {
                firstCur.next = head;
                firstCur = head;
            } else {
                secondCur.next = head;
                secondCur = head;
            }
            head = head.next;
        }
        firstCur.next = secondHead.next;
        secondCur.next = null;
        return firstHead.next;
    }
}
