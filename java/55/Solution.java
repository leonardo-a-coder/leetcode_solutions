public class Solution {
    public boolean canJump(int[] nums) {
        int cur = 0;
        int end = 0;
        while (cur <= end && end < nums.length - 1) {
            end = Math.max(end, cur + nums[cur]);
            cur++;
        }
        return end >= nums.length - 1;
    }
}
