public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        result.add(0);
        for (int i = 1; i <= n; i++) {
            int size = result.size();
            int cur = 1 << (i - 1);
            for (int j = size - 1; j >= 0; j--) {
                result.add(cur | result.get(j));
            }
        }
        return result;
    }
}
