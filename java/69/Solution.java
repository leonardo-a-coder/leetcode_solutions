public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (int) (end * end <= x ? end : start);
    }
}
