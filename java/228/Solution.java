public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (end + 1 >= nums[i]) {
                end = nums[i];
            } else {
                result.add(printRange(start, end));
                start = nums[i];
                end = nums[i];
            }
        }
        result.add(printRange(start, end));
        return result;
    }
    
    private String printRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return new StringBuilder().append(start).append("->").append(end).toString();
    }
}
