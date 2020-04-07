public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return result.next;
    }
}

