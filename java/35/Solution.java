public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[nums.length - 1] < target) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
