public class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        int right = nums.length - 1;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }
        if (left < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        while (right > left && nums[right] <= nums[left]) {
            right--;
        }
        swap(nums, left, right);
        reverse(nums, left + 1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
