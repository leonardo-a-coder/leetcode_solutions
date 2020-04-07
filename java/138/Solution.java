public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode newNode = new RandomListNode(cur.label);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode newHead = head.next;
        RandomListNode newCur = newHead;
        while (cur != null) {
            RandomListNode next = cur.next.next;
            cur.next = next;
            newCur.next = next == null ? null : next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
