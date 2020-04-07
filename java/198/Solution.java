public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[index] = Math.max(dp[index] + nums[i], dp[1 - index]);
            index = 1 - index;
        }
        return dp[1 - (nums.length & 1)];
    }
}
