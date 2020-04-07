public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subsetsWithDup(nums, i, result, cur, i == 0 ? null : nums[i - 1]);
        }
        return result;
    }
    
    private void subsetsWithDup(int[] nums, int index, List<List<Integer>> result, List<Integer> cur, Integer lastSkipped) {
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (lastSkipped != null && nums[index] == lastSkipped) {
            return;
        }
        cur.add(nums[index]);
        for (int i = index + 1; i <= nums.length; i++) {
            subsetsWithDup(nums, i, result, cur, i == index + 1 ? lastSkipped : Integer.valueOf(nums[i - 1]));
        }
        cur.remove(cur.size() - 1);
    }
}
