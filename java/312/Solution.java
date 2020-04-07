public class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] balloons = new int[len];
        int[][] dp = new int[len][len];
        balloons[0] = 1;
        balloons[len - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        for (int diff = 2; diff < len; diff++) {
            for (int left = 0; left < len - diff; left++) {
                int right = left + diff;
                for (int mid = left + 1; mid < right; mid++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][mid] + dp[mid][right] + balloons[left] * balloons[mid] * balloons[right]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
