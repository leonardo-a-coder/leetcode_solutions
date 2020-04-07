public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String cur = "1";
        for (int i = 1; i < n; i++) {
            cur = countNext(cur);
        }
        return cur;
    }
    
    private String countNext(String str) {
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = cur;
                count = 1;
            }
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
}
