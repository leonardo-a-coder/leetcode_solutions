public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        secondHead = reverse(secondHead);
        while (head != null && secondHead != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode result = reverse(next);
        next.next = head;
        return result;
    }
}
