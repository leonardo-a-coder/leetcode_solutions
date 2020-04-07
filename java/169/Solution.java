public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else {
                if (--count == 0) {
                    cur = nums[i];
                    count = 1;
                }
            }
        }
        return cur;
    }
}
