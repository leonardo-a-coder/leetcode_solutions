public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int end = 0;
        boolean hasDuplicate = false;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[end]) {
                if (!hasDuplicate) {
                    hasDuplicate = true;
                    nums[++end] = nums[i];
                }
            } else {
                hasDuplicate = false;
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
