public class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0 || x == 0) {
            return x;
        } else if (x == -1.0) {
            return (n & 1) == 0 ? -x : x;
        }
        return n >= 0 ? myPowAbs(x, n) : 1 / myPowAbs(x, -n);
    }
    
    private double myPowAbs(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = myPowAbs(x, n >>> 1);
        if ((n & 1) == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
