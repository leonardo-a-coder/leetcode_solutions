public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, result, new ArrayList<>(), false);
        return result;
    }
    
    private void combinationSum2(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> cur, boolean lastAdded) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        } else if (index == candidates.length || candidates[index] > target) {
            return;
        }
        combinationSum2(candidates, target, index + 1, result, cur, false);
        if (index == 0 || lastAdded || candidates[index - 1] != candidates[index]) {
            cur.add(candidates[index]);
            combinationSum2(candidates, target - candidates[index], index + 1, result, cur, true);
            cur.remove(cur.size() - 1);
        }
    }
}
