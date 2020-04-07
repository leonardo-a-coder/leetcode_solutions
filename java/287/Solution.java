public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int result = 0;
        while (result != slow) {
            result = nums[result];
            slow = nums[slow];
        }
        return result;
    }
}
