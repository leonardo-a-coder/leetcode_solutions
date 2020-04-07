public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subsets(nums, i, result, cur);
        }
        return result;
    }
    
    private void subsets(int[] nums, int index, List<List<Integer>> result, List<Integer> cur) {
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        for (int i = index + 1; i <= nums.length; i++) {
            subsets(nums, i, result, cur);
        }
        cur.remove(cur.size() - 1);
    }
}
