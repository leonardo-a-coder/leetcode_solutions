public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return result;
        }
        for (int i = 0; i < Math.min(m, n) >> 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i; j < m - i - 1; j++) {
                result.add(matrix[j][n - i - 1]);
            }
            for (int j = n - i - 1; j > i; j--) {
                result.add(matrix[m - i - 1][j]);
            }
            for (int j = m - i - 1; j > i; j--) {
                result.add(matrix[j][i]);
            }
        }
        if (m >= n) {
            if ((n & 1) == 1) {
                for (int i = n >> 1; i < m - (n >> 1); i++) {
                    result.add(matrix[i][n >> 1]);
                }
            }
        } else {
            if ((m & 1) == 1) {
                for (int j = m >> 1; j < n - (m >> 1); j++) {
                    result.add(matrix[m >> 1][j]);
                }
            }
        }
        return result;
    }
}
