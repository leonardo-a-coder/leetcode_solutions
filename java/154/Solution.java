public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return findMin(nums, 0, nums.length - 1, nums[0]);
    }
    
    private int findMin(int[] nums, int start, int end, int min) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) {
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            } else {
                min = Math.min(min, nums[mid]);
                min = findMin(nums, start, mid - 1, min);
                min = findMin(nums, mid + 1, end, min);
                return min;
            }
        }
        return min;
    }
}
