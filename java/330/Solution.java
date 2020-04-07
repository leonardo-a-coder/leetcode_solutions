public class Solution {
    public int minPatches(int[] nums, int n) {
        int result = 0;
        long max = 0;
        int index = 0;
        while (max < n) {
            if (index < nums.length && max >= nums[index] - 1) {
                max += nums[index++];
            } else {
                result++;
                max += max + 1;
            }
        }
        return result;
    }
}
