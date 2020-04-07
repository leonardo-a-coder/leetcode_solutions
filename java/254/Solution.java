public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        getFactors(n, result, new ArrayList<Integer>());
        return result;
    }
    
    private void getFactors(int n, List<List<Integer>> result, List<Integer> curr) {
        if (n == 1) {
                result.add(new ArrayList<Integer>(curr));
                return;
        }
        if (curr.size() > 0) {
            curr.add(n);
            result.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size() - 1);
        }
        for (int i = curr.size() == 0 ? 2 : curr.get(curr.size() - 1); i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                curr.add(i);
                getFactors(n / i, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
