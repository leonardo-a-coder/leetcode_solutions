public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cur = 1;
        for (int i = 0; i < n >> 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                result[i][j] = cur++;
            }
            for (int j = i; j < n - i - 1; j++) {
                result[j][n - i - 1] = cur++;
            }
            for (int j = n - i - 1; j > i; j--) {
                result[n - i - 1][j] = cur++;
            }
            for (int j = n - i - 1; j > i; j--) {
                result[j][i] = cur++;
            }
        }
        if ((n & 1) == 1) {
            result[n >> 1][n >> 1] = cur;
        }
        return result;
    }
}
