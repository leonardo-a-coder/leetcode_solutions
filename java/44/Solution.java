public class Solution {
    public boolean isMatch(String s, String p) {
        int indexS = 0;
        int indexP = 0;
        int lastS = -1;
        int lastStar = -1;
        while (indexS < s.length()) {
            boolean isMatch = true;
            if (indexP == p.length()) {
                isMatch = false;
            } else if (p.charAt(indexP) == '*') {
                lastS = indexS;
                lastStar = indexP;
                indexP++;
            } else if (p.charAt(indexP) == '?' || p.charAt(indexP) == s.charAt(indexS)) {
                indexS++;
                indexP++;
            } else {
                isMatch = false;
            }
            if (!isMatch) {
                if (lastStar < 0) {
                    return false;
                } else {
                    indexS = ++lastS;
                    indexP = lastStar + 1;
                }
            }
        }
        while (indexP < p.length()) {
            if (p.charAt(indexP++) != '*') {
                return false;
            }
        }
        return true;
    }
}
