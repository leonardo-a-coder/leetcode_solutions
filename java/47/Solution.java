public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        return permuteUnique(nums, 0);
    }
    
    private List<List<Integer>> permuteUnique(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == nums.length) {
            result.add(new ArrayList<>());
            return result;
        }
        for (List<Integer> list : permuteUnique(nums, index + 1)) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> cur = new ArrayList<>(list);
                cur.add(i, nums[index]);
                result.add(cur);
                if (i < list.size() && nums[index] == list.get(i)) {
                    break;
                }
            }
        }
        return result;
    }
}
