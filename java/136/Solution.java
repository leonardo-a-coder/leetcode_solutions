public class Solution {
    public int singleNumber(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            cur ^= num;
        }
        return cur;
    }
}
