public class WordDictionary {
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int index, TrieNode cur) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode next : cur.children) {
                    if (next != null && search(word, i + 1, next)) {
                        return true;
                    }
                }
                return false;
            } else {
                cur = cur.children[c - 'a'];
                if (cur == null) {
                    return false;
                }
            }
        }
        return cur.isWord;
    }
    
    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        
        private TrieNode() {
            children = new TrieNode[26];
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
