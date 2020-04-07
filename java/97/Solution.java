public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[] dp = new boolean[len1 + 1];
        dp[0] = true;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < len2; i++) {
            dp[0] &= s2.charAt(i) == s3.charAt(i);
            for (int j = 0; j < len1; j++) {
                dp[j + 1] = (dp[j] && s1.charAt(j) == s3.charAt(i + j + 1)) || (dp[j + 1] && s2.charAt(i) == s3.charAt(i + j + 1));
            }
        }
        return dp[len1];
    }
}
