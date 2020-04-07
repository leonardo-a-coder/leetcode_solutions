public class Solution {
    public int strStr(String haystack, String needle) {
         if (haystack.length() < needle.length()) {
             return -1;
         } else if (needle.length() == 0) {
             return 0;
         }
         int[] next = calculateNext(needle);
         int hIndex = 0;
         int nIndex = 0;
         while (hIndex < haystack.length() && nIndex < needle.length()) {
             if (nIndex == -1 || haystack.charAt(hIndex) == needle.charAt(nIndex)) {
                 hIndex++;
                 nIndex++;
             } else {
                 nIndex = next[nIndex];
             }
         }
         return nIndex == needle.length() ? hIndex - nIndex : -1;
    }
    
    private int[] calculateNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int v = -1;
        while (i < needle.length() - 1) {
            if (v == -1 || needle.charAt(i) == needle.charAt(v)) {
                ++i;
                ++v;
                next[i] = v;
            } else {
                v = next[v];
            }
        }
        return next;
    }
}
