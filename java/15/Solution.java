public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < len - 2) {
            int target = -nums[i];
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < target) {
                    while (++j < k && nums[j - 1] == nums[j]);
                } else if (sum > target) {
                    while (--k > j && nums[k] == nums[k + 1]);
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (++j < k && nums[j - 1] == nums[j]);
                    while (--k > j && nums[k] == nums[k + 1]);
                }
            }
            while (++i < len - 2 && nums[i - 1] == nums[i]);
        }
        return result;
    }
}
