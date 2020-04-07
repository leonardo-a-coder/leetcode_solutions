public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = cur;
            cur *= nums[i];
        }
        cur = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= cur;
            cur *= nums[i];
        }
        return result;
    }
}
