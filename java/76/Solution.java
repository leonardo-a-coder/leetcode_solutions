public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }
        int[] sCount = new int[128];
        int[] tCount = countCharacters(t);
        int matchCount = t.length();
        int resultStart = -1;
        int resultEnd = -1;
        int curStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sCount[c]++;
            if (sCount[c] <= tCount[c]) {
                matchCount--;
                if (matchCount == 0) {
                    while (sCount[s.charAt(curStart)] > tCount[s.charAt(curStart)]) {
                        sCount[s.charAt(curStart)]--;
                        curStart++;
                    }
                    if (resultStart == -1 || resultEnd - resultStart > i - curStart) {
                        resultStart = curStart;
                        resultEnd = i;
                    }
                    sCount[s.charAt(curStart)]--;
                    curStart++;
                    matchCount++;
                }
            }
        }
        return resultStart == -1 ? "" : s.substring(resultStart, resultEnd + 1);
    }
    
    private int[] countCharacters(String str) {
        int[] result = new int[128];
        for (int i = 0; i < str.length(); i++) {
            result[str.charAt(i)]++;
        }
        return result;
    }
}
