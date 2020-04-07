public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        int rowEnemyCount = 0;
        int[] colEnemyCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j] == 'W') {
                    rowEnemyCount = 0;
                    for (int k = grid[i][j] == 'W' ? j + 1 : 0; k < n; k++) {
                        if (grid[i][k] == 'E') {
                            rowEnemyCount++;
                        } else if (grid[i][k] == 'W') {
                            break;
                        }
                    }
                }
                if (i == 0 || grid[i][j] == 'W') {
                    colEnemyCount[j] = 0;
                    for (int k = grid[i][j] == 'W' ? i + 1 : 0; k < m; k++) {
                        if (grid[k][j] == 'E') {
                            colEnemyCount[j]++;
                        } else if (grid[k][j] == 'W') {
                            break;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    result = Math.max(result, rowEnemyCount + colEnemyCount[j]);
                }
            }
        }
        return result;
    }
}
