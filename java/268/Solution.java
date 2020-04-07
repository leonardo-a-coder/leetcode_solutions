public class Solution {
    public int missingNumber(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index && nums[index] < nums.length) {
                swap(nums, index, nums[index]);
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
