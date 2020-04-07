public class Solution {
    public boolean canWinNim(int n) {
        return n > 0 && (n & 3) != 0;
    }
}
