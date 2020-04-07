public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[2][n];
        int row = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[row][0] = 1;
                max = Math.max(max, dp[row][0]);
            } else {
                dp[row][0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[row][j] = Math.min(Math.min(dp[row][j - 1], dp[1 - row][j - 1]), dp[1 - row][j]) + 1;
                    max = Math.max(max, dp[row][j]);
                } else {
                    dp[row][j] = 0;
                }
            }
            row = 1 - row;
        }
        return max * max;
    }
}
