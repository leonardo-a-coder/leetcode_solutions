public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int last1 = -1;
        int last2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                last1 = i;
                if (last2 >= 0) {
                    result = Math.min(result, last1 - last2);
                }
            } else if (words[i].equals(word2)) {
                last2 = i;
                if (last1 >= 0) {
                    result = Math.min(result, last2 - last1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
