public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isNotPrime = new boolean[n];
        int count = n - 2;
        for (int i = 2; i * i < n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (!isNotPrime[j]) {
                        isNotPrime[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
