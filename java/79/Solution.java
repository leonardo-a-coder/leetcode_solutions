public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = m == 0 ? 0 : board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 1, m, n, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int m, int n, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '*';
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == word.charAt(index) && dfs(board, word, index + 1, m, n, newI, newJ)) {
                board[i][j] = c;
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
