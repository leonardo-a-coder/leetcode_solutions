public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        long result = target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0;
        while (i < len - 2) {
            int curTarget = target - nums[i];
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (Math.abs(target - result) > Math.abs(curTarget - sum)) {
                    result = nums[i] + sum;
                }
                if (sum < curTarget) {
                    while (++j < k && nums[j - 1] == nums[j]);
                } else if (sum > curTarget) {
                    while (--k > j && nums[k + 1] == nums[k]);
                } else {
                    return target;
                }
            }
            while (++i < len - 2 && nums[i - 1] == nums[i]);
        }
        return (int) result;
    }
}
