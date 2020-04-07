public class Solution {
    public int singleNumber(int[] nums) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = low ^ num & ~high;
            high = high ^ num & ~low;
        }
        return low;
    }
}
