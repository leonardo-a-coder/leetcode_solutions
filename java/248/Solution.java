public class Solution {
    private static char[] SINGLE_NUM = new char[] {'0', '1', '8'};
    private static char[][] DOUBLE_NUM = new char[][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public int strobogrammaticInRange(String low, String high) {
        int result = 0;
        char[] lowArr = low.toCharArray();
        char[] highArr = high.toCharArray();
        for (int i = lowArr.length; i <= highArr.length; i++) {
            result += strobogrammaticInRange(lowArr, highArr, new char[i], 0, i - 1);
        }
        return result;
    }
    
    private int strobogrammaticInRange(char[] low, char[] high, char[] cur, int start, int end) {
        int result = 0;
        if (start > end) {
            return compare(low, cur) <= 0 && compare(cur, high) <= 0 ? 1 : 0;
        } else if (start == end) {
            for (char c : SINGLE_NUM) {
                cur[start] = c;
                if (compare(low, cur) <= 0 && compare(cur, high) <= 0) {
                    result++;
                }
            }
        } else {
            for (char[] c : DOUBLE_NUM) {
                if (start > 0 || c[0] != '0') {
                    cur[start] = c[0];
                    cur[end] = c[1];
                    result += strobogrammaticInRange(low, high, cur, start + 1, end - 1);
                }
            }
        }
        return result;
    }
    
    private int compare(char[] num1, char[] num2) {
        if (num1.length != num2.length) {
            return Integer.compare(num1.length, num2.length);
        }
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] != num2[i]) {
                return Character.compare(num1[i], num2[i]);
            }
        }
        return 0;
    }
}
