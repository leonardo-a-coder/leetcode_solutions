public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int interval = (numRows - 1) << 1;
        for (int i = 0; i < len; i += interval) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int next = interval - ((numRows - i - 1) << 1);
            for (int j = i; j < len; j += next) {
                sb.append(s.charAt(j));
                next = interval - next;
            }
        }
        for (int i = numRows - 1; i < len; i += interval) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
