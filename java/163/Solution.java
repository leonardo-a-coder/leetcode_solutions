public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (cur < nums[i]) {
                result.add(generateString(cur, nums[i] - 1));
            }
            cur = nums[i] + 1;
        }
        if (cur <= upper) {
            result.add(generateString(cur, upper));
        }
        return result;
    }
    
    private String generateString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("->").append(end);
        }
        return sb.toString();
    }
}
