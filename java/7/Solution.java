public class Solution {
    public int reverse(int x) {
        long num = Math.abs((long) x);
        long result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        result = x >= 0 ? result : -result;
        return result == (int) result ? (int) result : 0;
    }
}
