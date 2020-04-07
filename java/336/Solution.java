public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int other : trie.searchWord(words[i], i)) {
                result.add(Arrays.asList(i, other));
            }
        }
        return result;
    }
    
    private class TrieNode {
        private TrieNode[] children;
        private int index;
        private List<Integer> subPalindromes;
        
        TrieNode() {
            children = new TrieNode[26];
            index = -1;
            subPalindromes = new ArrayList<>();
        }
    }
    
    private class Trie {
        private TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        private void addWord(String word, int index) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (isPalindrome(word, 0, i)) {
                    cur.subPalindromes.add(index);
                }
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            cur.index = index;
        }
        
        private List<Integer> searchWord(String word, int index) {
            TrieNode cur = root;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                if (cur.index >= 0 && cur.index != index && isPalindrome(word, i, word.length() - 1)) {
                    result.add(cur.index);
                }
                int c = word.charAt(i) - 'a';
                cur = cur.children[c];
                if (cur == null) {
                    return result;
                }
            }
            if (cur.index >= 0 && cur.index != index) {
                result.add(cur.index);
            }
            for (int sub : cur.subPalindromes) {
                if (sub != index) {
                    result.add(sub);
                }
            }
            return result;
        }
        
        private boolean isPalindrome(String word, int start, int end) {
            while (start < end) {
                if (word.charAt(start++) != word.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
