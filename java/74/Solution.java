public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        int minRow = 0;
        int maxRow = m - 1;
        while (minRow + 1 < maxRow) {
            int mid = minRow + (maxRow - minRow) / 2;
            if (matrix[mid][0] > target) {
                maxRow = mid - 1;
            } else {
                minRow = mid;
            }
        }
        int targetRow = matrix[maxRow][0] <= target ? maxRow : minRow;
        int minCol = 0;
        int maxCol = n - 1;
        while (minCol < maxCol) {
            int mid = minCol + (maxCol - minCol) / 2;
            if (matrix[targetRow][mid] < target) {
                minCol = mid + 1;
            } else {
                maxCol = mid;
            }
        }
        return matrix[targetRow][maxCol] == target;
    }
}
