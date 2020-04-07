public class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 || index2 < len2) {
            int cur1 = 0;
            int cur2 = 0;
            while (index1 < len1) {
                char c = version1.charAt(index1++);
                if (c == '.') {
                    break;
                }
                cur1 = cur1 * 10 + c - '0';
            }
            while (index2 < len2) {
                char c = version2.charAt(index2++);
                if (c == '.') {
                    break;
                }
                cur2 = cur2 * 10 + c - '0';
            }
            if (cur1 > cur2) {
                return 1;
            } else if (cur1 < cur2) {
                return -1;
            }
        }
        return 0;
    }
}
