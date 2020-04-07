public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        int end = -1;
        int[] count = countCharacters(s);
        boolean[] added = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            count[cur]--;
            if (added[cur]) {
                continue;
            }
            while (end >= 0 && arr[end] > cur && count[arr[end]] > 0) {
                added[arr[end]] = false;
                end--;
            }
            arr[++end] = cur;
            added[cur] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= end; i++) {
            sb.append((char) (arr[i] + 'a'));
        }
        return sb.toString();
    }
    
    private int[] countCharacters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }
}
