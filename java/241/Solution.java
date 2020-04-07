public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, new HashMap<>());
    }
    
    private List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> cache) {
        if (input.length() == 0) {
            return new ArrayList<>();
        } else if (cache.containsKey(input)) {
            return cache.get(input);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i), cache);
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1), cache);
                for (int left : leftList) {
                    for (int right : rightList) {
                        result.add(compute(left, right, c));
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.valueOf(input));
        }
        cache.put(input, result);
        return result;
    }
    
    private int compute(int left, int right, char c) {
        switch (c) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            default:
                throw new IllegalArgumentException("Invalid operator:" + c);
        }
    }
}
