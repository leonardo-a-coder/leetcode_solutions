public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int index = findFirstDiff(s, t);
        return isSame(s, t, s.length() >= t.length() ? index + 1 : index, t.length() >= s.length() ? index + 1 : index);
    }
    
    private int findFirstDiff(String s, String t) {
        int index = -1;
        while (++index < Math.min(s.length(), t.length())) {
            if (s.charAt(index) != t.charAt(index)) {
                break;
            }
        }
        return index;
    }
    
    private boolean isSame(String s, String t, int startS, int startT) {
        while (startS < s.length() && startT < t.length()) {
            if (s.charAt(startS++) != t.charAt(startT++)) {
                return false;
            }
        }
        return startS == s.length() && startT == t.length();
    }
}
