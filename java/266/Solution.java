public class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] arr = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c] = !arr[c];
        }
        boolean odd = false;
        for (int i = 0; i < 128; i++) {
            if (arr[i]) {
                if (odd) {
                    return false;
                } else {
                    odd = true;
                }
            }
        }
        return true;
    }
}
