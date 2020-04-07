public class Solution {
    public int[] singleNumber(int[] nums) {
        int mix = 0;
        for (int num : nums) {
            mix ^= num;
        }
        int mask = mix & -mix;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
