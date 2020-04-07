public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n > 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            n = getNextHappy(n);
        }
        return n == 1;
    }
    
    private int getNextHappy(int n) {
        int result = 0;
        while (n != 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }
}
