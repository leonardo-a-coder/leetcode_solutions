public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target);
        Arrays.sort(candidates);
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> cur = new ArrayList<>();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (candidates[j] == i) {
                    cur.add(Arrays.asList(candidates[j]));
                } else {
                    for (List<Integer> prev : dp.get(i - candidates[j] - 1)) {
                        if (candidates[j] <= prev.get(0)) {
                            List<Integer> newList = new ArrayList<>();
                            newList.add(candidates[j]);
                            newList.addAll(prev);
                            cur.add(newList);
                        }
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(target - 1);
    }
}
