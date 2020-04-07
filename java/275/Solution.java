public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] < citations.length - mid - 1) {
                start = mid;
            } else if (citations[mid] > citations.length - mid - 1) {
                end = mid;
            } else {
                return citations.length - mid - 1;
            }
        }
        if (citations[end] <= citations.length - end - 1) {
            return citations.length - end - 1;
        } else if (citations[start] <= citations.length - start - 1) {
            return citations.length - start - 1;
        } else {
            return citations.length;
        }
    }
}
