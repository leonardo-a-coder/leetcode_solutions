public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - min;
            if (arr[index] > 0 && i - arr[index] + 1 <= k) {
                return true;
            }
            arr[index] = i + 1;
        }
        return false;
    }
}
