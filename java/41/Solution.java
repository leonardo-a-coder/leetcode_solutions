public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur) {
                return cur;
            } else if (nums[i] == cur) {
                cur++;
            }
        }
        return cur;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
