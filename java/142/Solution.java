public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode result = head;
                while (result != slow) {
                    result = result.next;
                    slow = slow.next;
                }
                return result;
            }
        }
        return null;
    }
}
