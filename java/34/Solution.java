public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {nums.length, -1};
        searchRange(nums, target, result, 0, nums.length - 1);
        return result[0] <= result[1] ? result : new int[] {-1, -1};
    }
    
    private void searchRange(int[] nums, int target, int[] result, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                result[0] = Math.min(result[0], mid);
                result[1] = Math.max(result[1], mid);
                searchRange(nums, target, result, start, mid - 1);
                searchRange(nums, target, result, mid + 1, end);
                return;
            }
        }
    }
}
