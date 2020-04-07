public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        int[] factors = new int[3];
        int[] mul = new int[3];
        int[] indices = new int[3];
        dp[0] = 1;
        factors[0] = 2;
        factors[1] = 3;
        factors[2] = 5;
        mul[0] = 2;
        mul[1] = 3;
        mul[2] = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(mul[0], mul[1]), mul[2]);
            dp[i] = min;
            for (int j = 0; j < 3; j++) {
                if (mul[j] == min) {
                    mul[j] = factors[j] * dp[++indices[j]];
                }
            }
        }
        return dp[n - 1];
    }
}
