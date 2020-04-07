public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultHead = head;
        ListNode resultTail = head;
        head = head.next;
        resultTail.next = null;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < resultHead.val) {
                head.next = resultHead;
                resultHead = head;
            } else if (head.val >= resultTail.val) {
                resultTail.next = head;
                resultTail = head;
                head.next = null;
            } else {
                ListNode cur = resultHead;
                while (cur.next.val < head.val) {
                    cur = cur.next;
                }
                head.next = cur.next;
                cur.next = head;
            }
            head = next;
        }
        return resultHead;
    }
}
