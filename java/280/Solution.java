public class Solution {
    public void wiggleSort(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 1) {
                if (nums[i] < nums[i - 1]) {
                    swap(nums, i - 1, i);
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    swap(nums, i - 1, i);
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
