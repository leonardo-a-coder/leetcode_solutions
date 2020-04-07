public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int lastSq = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                result[i] = 1;
                lastSq = i;
            } else {
                result[i] = result[i - lastSq] + 1;
            }
        }
        return result;
    }
}
