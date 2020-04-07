public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countMergeSum(sums, lower, upper, 0, sums.length - 1);
    }
    
    private int countMergeSum(long[] sums, int lower, int upper, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int count = 0;
        int mid = start + (end - start) / 2;
        long[] cache = new long[end - start + 1];
        int cacheIndex = 0;
        int left = start;
        int right = mid + 1;
        int rangeLeft = mid + 1;
        int rangeRight = mid + 1;
        
        count += countMergeSum(sums, lower, upper, start, mid) + countMergeSum(sums, lower, upper, mid + 1, end);
        while (left <= mid) {
            while (rangeRight <= end && sums[rangeRight] - sums[left] <= upper) {
                rangeRight++;
            }
            while (rangeLeft <= end && sums[rangeLeft] - sums[left] < lower) {
                rangeLeft++;
            }
            count += rangeRight - rangeLeft;
            while (right <= end && sums[right] <= sums[left]) {
                cache[cacheIndex++] = sums[right++];
            }
            cache[cacheIndex++] = sums[left++];
        }
        for (int i = 0; i < cacheIndex; i++) {
            sums[start + i] = cache[i];
        }
        return count;
    }
}
