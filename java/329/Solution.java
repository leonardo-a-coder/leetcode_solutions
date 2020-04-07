public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] max = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, m, n, i, j, max));
            }
        }
        return result;
    }
    
    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] max) {
        if (max[i][j] > 0) {
            return max[i][j];
        }
        int result = 0;
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[i][j] < matrix[newI][newJ]) {
                result = Math.max(result, dfs(matrix, m, n, newI, newJ, max));
            }
        }
        max[i][j] = result + 1;
        return result + 1;
    }
}
