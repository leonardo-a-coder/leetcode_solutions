public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int l = m == 0 ? 0 : A[0].length;
        int n = l == 0 ? 0 : B[0].length;
        if (m == 0 || l == 0 || n == 0) {
            return new int[0][0];
        }
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < l; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < n; k++) {
                        C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return C;
    }
}
