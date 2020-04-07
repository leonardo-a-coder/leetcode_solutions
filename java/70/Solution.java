public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        int index = 0;
        for (int i = 3; i <= n; i++) {
            dp[index] += dp[1 - index];
            index = 1 - index;
        }
        return dp[1 - (n & 1)];
    }
}
