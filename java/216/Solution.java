public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(n, result, new Integer[k], 0, 1);
        return result;
    }
    
    private void combinationSum3(int target, List<List<Integer>> result, Integer[] cur, int index, int num) {
        if (index == cur.length) {
            if (target == 0) {
                result.add(new ArrayList<>(Arrays.asList(cur)));
            }
            return;
        }
        int left = cur.length - index;
        if (target < left * num || target > left * 9) {
            return;
        }
        for (int i = num; i <= 10 - left; i++) {
            cur[index] = i;
            combinationSum3(target - i, result, cur, index + 1, i + 1);
        }
    }
}
