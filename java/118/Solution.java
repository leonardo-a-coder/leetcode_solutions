public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        result.add(prev);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                cur.add(prev.get(j) + prev.get(j + 1));
            }
            cur.add(1);
            result.add(cur);
            prev = cur;
        }
        return result;
    }
}
