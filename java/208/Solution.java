class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }
    
    private TrieNode findNode(String str) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
