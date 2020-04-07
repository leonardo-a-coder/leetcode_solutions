public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        int bucketSize = (max - min - 1) / (nums.length - 1) + 1;
        int numBuckets = (max - min) / bucketSize + 1;
        int[] minBuckets = new int[numBuckets];
        int[] maxBuckets = new int[numBuckets];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            minBuckets[index] = Math.min(minBuckets[index], num);
            maxBuckets[index] = Math.max(maxBuckets[index], num);
        }
        int result = 0;
        int prevMax = maxBuckets[0];
        for (int i = 1; i < numBuckets; i++) {
            if (minBuckets[i] <= maxBuckets[i]) {
                result = Math.max(result, minBuckets[i] - prevMax);
                prevMax = maxBuckets[i];
            }
        }
        return result;
    }
}
