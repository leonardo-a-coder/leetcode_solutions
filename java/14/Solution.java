public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (true) {
            if (index == strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || strs[i].charAt(index) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
    }
}
