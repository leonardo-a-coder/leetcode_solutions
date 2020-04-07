public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int[] majority = new int[2];
        int[] count = new int[2];
        majority[0] = nums[0];
        count[0] = 1;
        int index = 0;
        while (++index < nums.length) {
            if (nums[index] == majority[0]) {
                count[0]++;
            } else {
                majority[1] = nums[index];
                count[1]++;
                break;
            }
        }
        if (index == nums.length) {
            return Arrays.asList(majority[0]);
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (majority[0] == nums[i]) {
                count[0]++;
            } else if (majority[1] == nums[i]) {
                count[1]++;
            } else if (count[0] == 0) {
                majority[0] = nums[i];
                count[0] = 1;
            } else if (count[1] == 0) {
                majority[1] = nums[i];
                count[1] = 1;
            } else {
                count[0]--;
                count[1]--;
            }
        }
        int[] total = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority[0]) {
                total[0]++;
            } else if (nums[i] == majority[1]) {
                total[1]++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (total[0] > nums.length / 3) {
            result.add(majority[0]);
        }
        if (total[1] > nums.length / 3) {
            result.add(majority[1]);
        }
        return result;
    }
}
