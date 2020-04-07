public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int curTarget = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] >= curTarget) {
                    k--;
                } else {
                    result += k - j;
                    j++;
                }
            }
        }
        return result;
    }
}
