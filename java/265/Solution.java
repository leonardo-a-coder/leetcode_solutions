public class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int k = costs[0].length;
        if (k == 1) {
            return costs[0][0];
        }
        int[] dp = new int[k];
        for (int i = 0; i < n; i++) {
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;
            int secondMinIndex = -1;
            int secondMinVal = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (dp[j] < minVal) {
                    secondMinIndex = minIndex;
                    secondMinVal = minVal;
                    minIndex = j;
                    minVal = dp[j];
                } else if (dp[j] < secondMinVal) {
                    secondMinIndex = j;
                    secondMinVal = dp[j];
                }
            }
            for (int j = 0; j < k; j++) {
                if (j != minIndex) {
                    dp[j] = minVal + costs[i][j];
                } else {
                    dp[j] = secondMinVal + costs[i][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            result = Math.min(result, dp[j]);
        }
        return result;
    }
}
