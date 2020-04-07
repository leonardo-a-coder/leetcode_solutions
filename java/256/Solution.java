public class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[2][3];
        int cur = 0;
        for (int i = 0; i < costs.length; i++) {
            dp[cur][0] = Math.min(dp[1 - cur][1], dp[1 - cur][2]) + costs[i][0];
            dp[cur][1] = Math.min(dp[1 - cur][0], dp[1 - cur][2]) + costs[i][1];
            dp[cur][2] = Math.min(dp[1 - cur][0], dp[1 - cur][1]) + costs[i][2];
            cur = 1 - cur;
        }
        return Math.min(Math.min(dp[1 - cur][0], dp[1 - cur][1]), dp[1 - cur][2]);
    }
}
