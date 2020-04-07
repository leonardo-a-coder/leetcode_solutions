public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        long result = 0;
        long base = 1;
        long num = n;
        while (num >= base) {
            long left = num / base;
            long right = num % base;
            if (left % 10 > 1) {
                result += (left / 10 + 1) * base;
            } else if (left % 10 == 1) {
                result += left / 10 * base + right + 1;
            } else {
                result += left / 10 * base;
            }
            base *= 10;
        }
        return (int) result;
    }
}
