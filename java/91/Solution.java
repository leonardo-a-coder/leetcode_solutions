public class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0 || arr[0] == '0') {
            return 0;
        }
        int[] dp = new int[2];
        Arrays.fill(dp, 1);
        int cur = 0;
        for (int i = 1; i < arr.length; i++) {
            cur = 1 - cur;
            if (arr[i] == '0') {
                if (arr[i - 1] == '0' || arr[i - 1] > '2') {
                    return 0;
                }
            } else if (arr[i - 1] == '1' || (arr[i - 1] == '2' && arr[i] <= '6')) {
                dp[cur] += dp[1 - cur];
            } else {
                dp[cur] = dp[1 - cur];
            }
        }
        return dp[1 - (arr.length & 1)];
    }
}
