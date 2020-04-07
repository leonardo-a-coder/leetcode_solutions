public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = m == 0 ? 0 : rooms[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, m, n, i, j);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, int m, int n, int i, int j) {
        int distance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * n + j);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int curI = cur / n;
                int curJ = cur % n;
                for (int[] direction : DIRECTIONS) {
                    int newI = curI + direction[0];
                    int newJ = curJ + direction[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && rooms[newI][newJ] > distance + 1) {
                        rooms[newI][newJ] = distance + 1;
                        queue.add(newI * n + newJ);
                    }
                }
            }
            distance++;
        }
    }
}


public class Solution {
    public static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = m == 0 ? 0 : rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    fill(rooms, m, n, i, j, 0);
                }
            }
        }
    }
    
    private void fill(int[][] rooms, int m, int n, int i, int j, int steps) {
        rooms[i][j] = Math.min(rooms[i][j], steps);
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && rooms[newI][newJ] > steps + 1) {
                fill(rooms, m, n, newI, newJ, steps + 1);
            }
        }
    }
}
