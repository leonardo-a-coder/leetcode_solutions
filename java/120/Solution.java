public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            dp[i] = list.get(i) + dp[i - 1];
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
            }
            dp[0] += list.get(0);
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < dp.length; j++) {
            result = Math.min(result, dp[j]);
        }
        return result;
    }
}
