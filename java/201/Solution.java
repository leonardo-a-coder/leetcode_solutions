public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int highestDiffBit = 0;
        int base = 1;
        for (int i = 0; i < 31; i++) {
            if ((m & base) != (n & base)) {
                highestDiffBit = base;
            }
            base <<= 1;
        }
        return m & ~((highestDiffBit << 1) - 1);
    }
}
