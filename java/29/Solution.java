public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        int result = 0;
        while (longDividend >= longDivisor) {
            int round = 1;
            long nextDivisor = longDivisor << 1;
            while (longDividend >= nextDivisor) {
                round <<= 1;
                nextDivisor <<= 1;
            }
            result += round;
            longDividend -= nextDivisor >> 1;
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            result = -result;
        }
        return result;
    }
}
