public class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isVowel(s.charAt(start))) {
                start++;
            }
            while (start < end && !isVowel(s.charAt(end))) {
                end--;
            }
            if (start < end) {
                swap(arr, start++, end--);
            }
        }
        return new String(arr);
    }
    
    private void swap(char[] arr, int start, int end) {
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    
    private boolean isVowel(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) ('a' + (c - 'A'));
        }
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}