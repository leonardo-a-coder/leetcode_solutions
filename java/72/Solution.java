public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[2][len2 + 1];
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            int curRow = i & 1;
            dp[curRow][0] = i;
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                if (c1 == word2.charAt(j - 1)) {
                    dp[curRow][j] = dp[1 - curRow][j - 1];
                } else {
                    dp[curRow][j] = Math.min(Math.min(dp[1 - curRow][j - 1], dp[1 - curRow][j]), dp[curRow][j - 1]) + 1;
                }
            }
        }
        return dp[len1 & 1][len2];
    }
}
