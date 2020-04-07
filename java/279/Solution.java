public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int cur = 0;
        for (int j = 1; (cur = j * j) <= n; j++) {
            for (int i = cur; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - cur] + 1);
            }
        }
        return dp[n];
    }
}
