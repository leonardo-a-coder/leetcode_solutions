public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int newEnd = -1;
        int oldStart = 0;
        int oldEnd = 0;
        while (oldStart < arr.length) {
            while (oldStart < arr.length && arr[oldStart] == ' ') {
                oldStart++;
            }
            if (oldStart == arr.length) {
                break;
            }
            oldEnd = oldStart + 1;
            while (oldEnd < arr.length && arr[oldEnd] != ' ') {
                oldEnd++;
            }
            if (newEnd >= 0) {
                arr[++newEnd] = ' ';
            }
            int len = oldEnd - oldStart;
            copy(arr, oldStart, ++newEnd, len);
            reverse(arr, newEnd, newEnd + len - 1);
            newEnd += len - 1;
            oldStart = oldEnd;
        }
        reverse(arr, 0, newEnd);
        return new String(arr, 0, newEnd + 1);
    }
    
    private void copy(char[] arr, int srcStart, int targetStart, int len) {
        for (int i = 0; i < len; i++) {
            arr[targetStart + i] = arr[srcStart + i];
        }
    }
    
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char c = arr[start];
            arr[start++] = arr[end];
            arr[end--] = c;
        }
    }
}
