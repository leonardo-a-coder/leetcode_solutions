public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNums = new int[n];
        int[] indices = new int[primes.length];
        int[] curNums = Arrays.copyOf(primes, primes.length);
        TreeSet<Integer> set = new TreeSet<>();
        uglyNums[0] = 1;
        for (int prime : primes) {
            set.add(prime);
        }
        for (int i = 1; i < n; i++) {
            int min = set.pollFirst();
            uglyNums[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (curNums[j] == min) {
                    curNums[j] = primes[j] * uglyNums[++indices[j]];
                    set.add(curNums[j]);
                }
            }
        }
        return uglyNums[n - 1];
    }
}



public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNums = new int[n];
        int[] indices = new int[primes.length];
        int[] curNums = Arrays.copyOf(primes, primes.length);
        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int num : curNums) {
                min = Math.min(min, num);
            }
            uglyNums[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (curNums[j] == min) {
                    curNums[j] = primes[j] * uglyNums[++indices[j]];
                }
            }
        }
        return uglyNums[n - 1];
    }
}
