public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int index = 1;
        while (index < nums.length) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
            index++;
        }
        if (index == nums.length) {
            return false;
        }
        int index1 = index - 1;
        int index2 = index;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index2]) {
                return true;
            } else if (nums[i] > nums[index1]) {
                index2 = i;
            } else {
                index1 = i;
            }
        }
        return false;
    }
}
