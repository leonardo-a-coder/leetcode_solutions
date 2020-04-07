public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int same = 0;
        int notSame = 1;
        for (int i = 1; i < n; i++) {
            int total = same * (k - 1) + notSame * k;
            same = notSame;
            notSame = total - same;
        }
        return (same + notSame) * k;
    }
}
