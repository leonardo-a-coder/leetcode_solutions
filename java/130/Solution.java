public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = m == 0 ? 0 : board[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                fillBoarder(board, m, n, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                fillBoarder(board, m, n, i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                fillBoarder(board, m, n, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                fillBoarder(board, m, n, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void fillBoarder(char[][] board, int m, int n, int i, int j) {
        board[i][j] = '#';
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * n + j);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curI = cur / n;
            int curJ = cur % n;
            for (int[] direction : DIRECTIONS) {
                int newI = curI + direction[0];
                int newJ = curJ + direction[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == 'O') {
                    board[newI][newJ] = '#';
                    queue.add(newI * n + newJ);
                }
            }
        }
    }
}
