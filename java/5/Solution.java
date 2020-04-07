public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int newEnd = 1; newEnd < len; newEnd++) {
            int newStart = newEnd - (end - start + 1);
            if (newStart >= 0 && isPalindrome(s, newStart, newEnd)) {
                start = newStart;
                end = newEnd;
            }
            newStart--;
            if (newStart >= 0 && isPalindrome(s, newStart, newEnd)) {
                start = newStart;
                end = newEnd;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
