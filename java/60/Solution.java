public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = getList(n);
        int factorial = getFactorial(n);
        k--;
        k %= factorial;
        while (n > 0) {
            factorial /= n;
            int cur = k / factorial;
            sb.append(list.remove(cur));
            k %= factorial;
            n--;
        }
        return sb.toString();
    }
    
    private List<Integer> getList(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        return result;
    }
    
    private int getFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
