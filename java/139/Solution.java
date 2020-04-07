public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        int maxWordLen = maxWordLen(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (dp[i]) {
                for (int j = i; j < len && j - i < maxWordLen; j++) {
                    if (!dp[j + 1] && wordDict.contains(s.substring(i, j + 1))) {
                        dp[j + 1] = true;
                    }
                }
            }
        }
        return dp[len];
    }
    
    private int maxWordLen(Set<String> wordDict) {
        int result = 0;
        for (String word : wordDict) {
            result = Math.max(result, word.length());
        }
        return result;
    }
}
