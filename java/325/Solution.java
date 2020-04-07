public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                result = i + 1;
            } else if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}


public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < sums.length; i++) {
            if (!map.containsKey(sums[i])) {
                map.put(sums[i], i);
            }
        }
        int result = 0;
        for (int i = sums.length - 1; i > result; i--) {
            if (map.containsKey(sums[i] - k)) {
                result = Math.max(result, i - map.get(sums[i] - k));
            }
        }
        return result;
    }
}
