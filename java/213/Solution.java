public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
        }
    }
    
    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        int index = 1;
        for (int i = start + 1; i <= end; i++) {
            dp[index] = Math.max(dp[index] + nums[i], dp[1 - index]);
            index = 1 - index;
        }
        return Math.max(dp[0], dp[1]);
    }
}
