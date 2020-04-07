public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        int depth = 1;
        for (NestedInteger ni : nestedList) {
            queue.add(ni);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    sum += cur.getInteger() * depth;
                } else {
                    for (NestedInteger ni : cur.getList()) {
                        queue.add(ni);
                    }
                }
            }
            depth++;
        }
        return sum;
    }
}
