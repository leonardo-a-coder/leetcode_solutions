public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = m == 0 ? 0 : obstacleGrid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (dp[0] == 1 && obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                dp[j] = obstacleGrid[i][j] == 0 ? dp[j] + dp[j - 1] : 0;
            }
        }
        return dp[n - 1];
    }
}
