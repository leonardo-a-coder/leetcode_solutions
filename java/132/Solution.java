public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = i - 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; i + j < len && i - j >= 0 && s.charAt(i + j) == s.charAt(i - j); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j] + 1);
            }
            for (int j = 0; i + j < len && i - j - 1 >= 0 && s.charAt(i + j) == s.charAt(i - j - 1); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i - j - 1] + 1);
            }
        }
        return dp[len];
    }
}
