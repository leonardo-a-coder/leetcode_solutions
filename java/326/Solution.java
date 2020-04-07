public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        long num = n;
        return Math.pow(3, Math.round(Math.log(num) / Math.log(3))) == num;
    }
}
