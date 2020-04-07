public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }
        char[] mapping = new char[128];
        boolean[] isVisited = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (mapping[charS] == 0) {
                if (isVisited[charT]) {
                    return false;
                } else {
                    mapping[charS] = charT;
                    isVisited[charT] = true;
                }
            } else if (mapping[charS] != charT) {
                return false;
            }
        }
        return true;
    }
}
