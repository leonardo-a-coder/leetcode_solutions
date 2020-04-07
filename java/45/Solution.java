public class Solution {
    public int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < nums.length - 1) {
            count++;
            int next = end;
            for (int i = start; i <= end; i++) {
                next = Math.max(next, i + nums[i]);
            }
            if (next == end) {
                return -1;
            } else {
                start = end + 1;
                end = next;
            }
        }
        return count;
    }
}
