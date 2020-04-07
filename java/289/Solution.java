public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = m == 0 ? 0 : board[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, m, n, i, j);
                if ((board[i][j] & 1) == 1) {
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        board[i][j] |= 2;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] |= 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>>= 1;
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && (board[newI][newJ] & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
