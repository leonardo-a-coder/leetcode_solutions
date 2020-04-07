public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        boolean isFirstRowZero = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
