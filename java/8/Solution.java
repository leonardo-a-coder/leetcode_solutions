public class Solution {
    public int myAtoi(String str) {
        boolean isPositive = true;
        long num = 0;
        int index = 0;
        int len = str.length();
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            isPositive = false;
        }
        for (int i = 0; i <= 10; i++) {
            if (index == len || !Character.isDigit(str.charAt(index))) {
                break;
            }
            num = num * 10 + (str.charAt(index++) - '0');
        }
        num = isPositive ? num : -num;
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) num;
        }
    }
}
