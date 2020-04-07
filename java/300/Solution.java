public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] arr = new int[nums.length];
        int tail = -1;
        for (int i = 0; i < nums.length; i++) {
            if (tail == -1 || arr[tail] < nums[i]) {
                arr[++tail] = nums[i];
            } else {
                int index = findFirstLargerOrEqual(arr, 0, tail, nums[i]);
                arr[index] = nums[i];
            }
        }
        return tail + 1;
    }
    
    private int findFirstLargerOrEqual(int[] arr, int start, int end, int num) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return arr[start] < num ? end : start;
    }
}
