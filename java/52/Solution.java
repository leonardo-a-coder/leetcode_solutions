public class Solution {
    public int totalNQueens(int n) {
        return totalNQueens(new int[n], 0);
    }
    
    private int totalNQueens(int[] board, int index) {
        if (index == board.length) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, index, i)) {
                board[index] = i;
                result += totalNQueens(board, index + 1);
            }
        }
        return result;
    }
    
    private boolean isValid(int[] board, int index, int num) {
        for (int i = 0; i < index; i++) {
            if (board[i] == num || Math.abs(index - i) == Math.abs(num - board[i])) {
                return false;
            }
        }
        return true;
    }
}
