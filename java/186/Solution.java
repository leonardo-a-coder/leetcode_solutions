public class Solution {
    public void reverseWords(char[] s) {
        int start = 0;
        int end = 0;
        while (start < s.length) {
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverse(s, start, end - 1);
            start = ++end;
        }
        reverse(s, 0, s.length - 1);
    }
    
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start++] = s[end];
            s[end--] = c;
        }
    }
}
