public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        num = divideFactor(num, 2);
        num = divideFactor(num, 3);
        num = divideFactor(num, 5);
        return num == 1;
    }
    
    private int divideFactor(int num, int factor) {
        while (num % factor == 0) {
            num /= factor;
        }
        return num;
    }
}
