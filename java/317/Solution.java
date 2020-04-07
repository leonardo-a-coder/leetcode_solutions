public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] distances = new int[m][n];
        int[][] reachable = new int[m][n];
        int numBuildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, distances, reachable, i, j, m, n, numBuildings);
                    numBuildings++;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reachable[i][j] == numBuildings) {
                    result = Math.min(result, distances[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private void bfs(int[][] grid, int[][] distances, int[][] reachable, int i, int j, int m, int n, int numBuildings) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int distance = 0;
        reachable[i][j]++;
        queue.add(i * n + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int curI = cur / n;
                int curJ = cur % n;
                for (int[] direction : DIRECTIONS) {
                    int newI = curI + direction[0];
                    int newJ = curJ + direction[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ] && grid[newI][newJ] == 0 && reachable[newI][newJ] == numBuildings) {
                        distances[newI][newJ] += distance;
                        reachable[newI][newJ]++;
                        queue.add(newI * n + newJ);
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
    }
}
