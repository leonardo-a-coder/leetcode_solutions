public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isRowValid(board) && isColValid(board) && isBlockValid(board);
    }
    
    private boolean isRowValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] flags = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isValid(board, flags, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isColValid(char[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] flags = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && !isValid(board, flags, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isBlockValid(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] flags = new boolean[9];
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] != '.' && !isValid(board, flags, m, n)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, boolean[] flags, int i, int j) {
        int cur = board[i][j] - '1';
        if (flags[cur]) {
            return false;
        } else {
            flags[cur] = true;
        }
        return true;
    }
}
