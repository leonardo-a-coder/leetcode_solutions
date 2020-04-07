public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        return permute(nums, 0);
    }
    
    private List<List<Integer>> permute(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == nums.length) {
            result.add(new ArrayList<>());
            return result;
        }
        for (List<Integer> list : permute(nums, index + 1)) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i, nums[index]);
                result.add(newList);
            }
        }
        return result;
    }
}
