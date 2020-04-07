public class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS < lenT) {
            return 0;
        }
        int[] dp = new int[lenT + 1];
        dp[0] = 1;
        for (int i = 0; i < lenS; i++) {
            for (int j = Math.min(i, lenT - 1); j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[lenT];
    }
}
