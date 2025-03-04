public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = m == 0 ? 0 : dungeon[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j + 1] - dungeon[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i][n - 1]);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(1, Math.min(dp[j], dp[j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0];
    }
}
