public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0 || n > 10) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }
        int result = 10;
        int cur = 9;
        for (int i = 2; i <= n; i++) {
            cur *= 11 - i;
            result += cur;
        }
        return result;
    }
}
