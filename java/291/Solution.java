public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return wordPattern(pattern, str, 0, 0, new String[26], new HashSet<>());
    }
    
    private boolean wordPattern(String pattern, String str, int patternIndex, int strIndex, String[] patternMatch, Set<String> visitedStr) {
        if (patternIndex == pattern.length() && strIndex == str.length()) {
            return true;
        } else if (patternIndex == pattern.length() || strIndex == str.length()) {
            return false;
        }
        int curPattern = pattern.charAt(patternIndex) - 'a';
        if (patternMatch[curPattern] == null) {
            for (int i = strIndex; i <= str.length() - (pattern.length() - patternIndex); i++) {
                String curStr = str.substring(strIndex, i + 1);
                if (!visitedStr.contains(curStr)) {
                    patternMatch[curPattern] = curStr;
                    visitedStr.add(curStr);
                    if (wordPattern(pattern, str, patternIndex + 1, i + 1, patternMatch, visitedStr)) {
                        return true;
                    }
                    patternMatch[curPattern] = null;
                    visitedStr.remove(curStr);
                }
            }
        } else if (str.length() - strIndex >= patternMatch[curPattern].length()) {
            String curStr = str.substring(strIndex, strIndex + patternMatch[curPattern].length());
            if (curStr.equals(patternMatch[curPattern])) {
                return wordPattern(pattern, str, patternIndex + 1, strIndex + patternMatch[curPattern].length(), patternMatch, visitedStr);
            }
        }
        return false;
    }
}
