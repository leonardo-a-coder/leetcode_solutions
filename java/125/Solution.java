public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !isAlpha(s.charAt(i)) && !isNumeric(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlpha(s.charAt(j)) && !isNumeric(s.charAt(j))) {
                j--;
            }
            if (i < j && !isEqual(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
    
    private boolean isNumeric(char c) {
        return (c >= '0' && c <= '9');
    }
    
    private boolean isEqual(char a, char b) {
        if (isAlpha(a) && isAlpha(b)) {
            return toLowerCase(a) == toLowerCase(b);
        } else {
            return a == b;
        }
    }
    
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) ('a' + (c - 'A'));
        } else {
            return c;
        }
    }
}
