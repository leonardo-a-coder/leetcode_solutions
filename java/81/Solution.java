public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    private boolean search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[start] == nums[mid] || nums[mid] == nums[end]) {
                return search(nums, target, start, mid - 1) || search(nums, target, mid + 1, end);
            } else if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
