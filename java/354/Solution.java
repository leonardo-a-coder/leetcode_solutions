public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        int[] arr = new int[envelopes.length];
        int tail = -1;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[0] != e2[0] ? Integer.compare(e1[0], e2[0]) : Integer.compare(e2[1], e1[1]);
            }
        });
        for (int[] envelope : envelopes) {
            if (tail == - 1 || arr[tail] < envelope[1]) {
                arr[++tail] = envelope[1];
            } else {
                int index = findFirstLargerOrEqual(arr, 0, tail, envelope[1]);
                arr[index] = envelope[1];
            }
        }
        return tail + 1;
    }
    
    private int findFirstLargerOrEqual(int[] arr, int start, int end, int num) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return arr[start] < num ? end : start;
    }
}
