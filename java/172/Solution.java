public class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            int next = n / 5;
            result += next;
            n = next;
        }
        return result;
    }
}
