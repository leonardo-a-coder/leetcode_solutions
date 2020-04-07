public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, getEmptyCells(board), 0);
    }
    
    private List<Integer> getEmptyCells(char[][] board) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    result.add(i * 9 + j);
                }
            }
        }
        return result;
    }
    
    private boolean solveSudoku(char[][] board, List<Integer> emptyCells, int index) {
        if (index == emptyCells.size()) {
            return true;
        }
        int curIndex = emptyCells.get(index);
        int i = curIndex / 9;
        int j = curIndex % 9;
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (solveSudoku(board, emptyCells, index + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        for (int i = row - row % 3; i < row - row % 3 + 3; i++) {
            for (int j = col - col % 3; j < col - col % 3 + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
