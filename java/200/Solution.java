public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs(char[][] grid, int m, int n, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * n + j);
        grid[i][j] = '2';
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curI = cur / n;
            int curJ = cur % n;
            for (int[] direction : DIRECTIONS) {
                int newI = curI + direction[0];
                int newJ = curJ + direction[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1') {
                    grid[newI][newJ] = '2';
                    queue.add(newI * n + newJ);
                }
            }
        }
    }
}


public class Solution {
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, (char) (count + 1 + '0'));
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, char fill) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = fill;
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1') {
                dfs(grid, newI, newJ, fill);
            }
        }
    }
}