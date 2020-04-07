public class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int cur = 0;
        while (cur <= blue) {
            if (nums[cur] == 0) {
                swap(nums, cur++, red++);
            } else if (nums[cur] == 2) {
                swap(nums, cur, blue--);
            } else {
                cur++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
