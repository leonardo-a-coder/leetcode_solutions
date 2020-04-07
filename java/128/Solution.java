public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                int count = 1;
                set.remove(num);
                int cur = num + 1;
                while (set.contains(cur)) {
                    count++;
                    set.remove(cur++);
                }
                cur = num - 1;
                while (set.contains(cur)) {
                    count++;
                    set.remove(cur--);
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
