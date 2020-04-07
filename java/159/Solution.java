public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) {
            return s.length();
        }
        int result = 0;
        int[] lastIndex = new int[2];
        char[] chars = new char[2];
        int start = 0;
        chars[0] = s.charAt(0);
        int index = 1;
        while (index < s.length() && s.charAt(index) == chars[0]) {
            index++;
        }
        if (index == s.length()) {
            return s.length();
        }
        lastIndex[0] = index - 1;
        lastIndex[1] = index;
        chars[1] = s.charAt(index);
        index++;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == chars[0]) {
                lastIndex[0] = index;
            } else if (c == chars[1]) {
                lastIndex[1] = index;
            } else {
                result = Math.max(result, index - start);
                if (lastIndex[0] < lastIndex[1]) {
                    start = lastIndex[0] + 1;
                    lastIndex[0] = index;
                    chars[0] = c;
                } else {
                    start = lastIndex[1] + 1;
                    lastIndex[1] = index;
                    chars[1] = c;
                }
            }
            index++;
        }
        result = Math.max(result, s.length() - start);
        return result;
    }
}
