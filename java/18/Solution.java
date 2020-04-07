public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        int i = 0;
        Arrays.sort(nums);
        while (i < len - 3) {
            if ((nums[i] << 2) > target) {
                break;
            }
            int l = len - 1;
            while (l > i + 2) {
                if ((nums[l] << 2) < target) {
                    break;
                }
                int j = i + 1;
                int k = l - 1;
                int curTarget = target - nums[i] - nums[l];
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum < curTarget) {
                        while (++j < k && nums[j] == nums[j - 1]);
                    } else if (sum > curTarget) {
                        while (--k > j && nums[k] == nums[k + 1]);
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (++j < k && nums[j] == nums[j - 1]);
                        while (--k > j && nums[k] == nums[k + 1]);
                    }
                }
                while (--l > i + 2 && nums[l] == nums[l + 1]);
            }
            while (++i < len - 3 && nums[i] == nums[i - 1]);
        }
        return result;
    }
}
