public class Solution {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        char[] full = new StringBuilder().append(s).append('#').append(reversed).toString().toCharArray();
        int[] prefix = new int[full.length];
        for (int i = 1; i < full.length; i++) {
            int j = prefix[i - 1];
            while (j > 0 && full[i] != full[j]) {
                j = prefix[j - 1];
            }
            prefix[i] = j + (full[i] == full[j] ? 1 : 0);
        }
        return new StringBuilder(reversed.substring(0, reversed.length() - prefix[prefix.length - 1])).append(s).toString();
    }
}
