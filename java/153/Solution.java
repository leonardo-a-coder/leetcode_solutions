public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int result = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid]) {
                result = Math.min(result, nums[start]);
                start = mid + 1;
            } else {
                result = Math.min(result, nums[mid]);
                end = mid - 1;
            }
        }
        return result;
    }
}
