public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                while (sum >= s) {
                    sum -= nums[start++];
                }
                result = Math.min(result, i - start + 2);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
