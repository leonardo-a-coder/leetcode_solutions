public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0 || n < k) {
            return result;
        }
        combine(n, k, 1, result, new ArrayList<>());
        return result;
    }
    
    private void combine(int n, int k, int cur, List<List<Integer>> result, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        int size = list.size();
        for (int i = cur; i <= n - k + 1; i++) {
            list.add(i);
            combine(n, k - 1, i + 1, result, list);
            list.remove(size);
        }
    }
}
