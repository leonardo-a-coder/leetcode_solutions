public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            result = Math.max(result, cur);
            cur = Math.max(cur, 0);
        }
        return result;
    }
}
