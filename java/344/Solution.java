public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
        return new String(arr);
    }
}
