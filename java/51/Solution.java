public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(new int[n], 0, result);
        return result;
    }
    
    private void solveNQueens(int[] board, int index, List<List<String>> result) {
        if (index == board.length) {
            result.add(generateResult(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, index, i)) {
                board[index] = i;
                solveNQueens(board, index + 1, result);
            }
        }
    }
    
    private boolean isValid(int[] board, int index, int pos) {
        for (int i = 0; i < index; i++) {
            if (board[i] == pos || index - i == Math.abs(board[i] - pos)) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> generateResult(int[] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[i]; j++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int j = board[i] + 1; j < board.length; j++) {
                sb.append('.');
            }
            result.add(sb.toString());
        }
        return result;
    }
}
