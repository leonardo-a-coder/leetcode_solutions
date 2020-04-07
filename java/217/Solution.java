public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        boolean[] visited = new boolean[max - min + 1];
        for (int num : nums) {
            int index = num - min;
            if (visited[index]) {
                return true;
            } else {
                visited[index] = true;
            }
        }
        return false;
    }
}
