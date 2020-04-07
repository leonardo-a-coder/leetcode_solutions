public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (node1, node2) -> Integer.compare(node1.val, node2.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return result.next;
    }
}
