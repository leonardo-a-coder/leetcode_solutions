public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.getFirst()];
                if (i - queue.getFirst() == k - 1) {
                    queue.removeFirst();
                }
            }
        }
        return result;
    }
}
