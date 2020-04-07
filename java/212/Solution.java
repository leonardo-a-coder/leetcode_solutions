public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = m == 0 ? 0 : board[0].length;
        if (m == 0 || n == 0 || words.length == 0) {
            return result;
        }
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(root, word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, m, n, i, j, result, root);
            }
        }
        return result;
    }
    
    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }
    
    private void dfs(char[][] board, int m, int n, int i, int j, List<String> result, TrieNode node) {
        char c = board[i][j];
        if (node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        for (int[] direction : DIRECTIONS) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] != '#') {
                dfs(board, m, n, newI, newJ, result, node);
            }
        }
        board[i][j] = c;
    }
    
    private class TrieNode {
        private TrieNode[] children;
        private String word;
    
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
