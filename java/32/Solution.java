public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int lenS = s.length();
        int[] dp = new int[lenS];
        for (int i = 1; i < lenS; i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            int left = i - dp[i - 1] - 1;
            if (left >= 0 && s.charAt(left) == '(') {
                dp[i] = dp[i - 1] + 2;
                if (left - 1 >= 0) {
                    dp[i] += dp[left - 1];
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
}
