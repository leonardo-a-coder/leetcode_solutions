public class TicTacToe {
    private int[][] board;
    private int winner;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (winner != 0) {
            return winner;
        }
        if (board[row][col] != 0) {
            throw new IllegalArgumentException("Invalid move.");
        }
        board[row][col] = player;
        if (isOver(row, col, player)) {
            winner = player;
            return winner;
        } else {
            return 0;
        }
    }
    
    private boolean isOver(int row, int col, int player) {
        return isRowOver(row, player) || isColOver(col, player) || isDiagonalOver(row, col, player) || isBackwardDiagonalOver(row, col, player);
    }
    
    private boolean isRowOver(int row, int player) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] != player) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isColOver(int col, int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isDiagonalOver(int row, int col, int player) {
        if (row != col) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isBackwardDiagonalOver(int row, int col, int player) {
        if (row + col != board.length - 1) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] != player) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
