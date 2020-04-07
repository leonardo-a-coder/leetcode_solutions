public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddCur = oddHead;
        ListNode evenCur = evenHead;
        while (head != null) {
            oddCur.next = head;
            oddCur = head;
            head = head.next;
            if (head == null) {
                break;
            }
            evenCur.next = head;
            evenCur = head;
            head = head.next;
        }
        oddCur.next = evenHead.next;
        evenCur.next = null;
        return oddHead.next;
    }
}
