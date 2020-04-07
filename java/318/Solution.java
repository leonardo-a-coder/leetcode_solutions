public class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        int[] encoded = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            encoded[i] = encode(words[i]);
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((encoded[i] & encoded[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
    
    private int encode(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            result |= 1 << (word.charAt(i) - 'a');
        }
        return result;
    }
}
