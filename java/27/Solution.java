public class Solution {
    public int removeElement(int[] nums, int val) {
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
