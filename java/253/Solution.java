public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int startIndex = 0;
        int endIndex = 0;
        int result = 0;
        int cur = 0;
        while (startIndex < len) {
            if (starts[startIndex] < ends[endIndex]) {
                cur++;
                result = Math.max(result, cur);
                startIndex++;
            } else {
                cur--;
                endIndex++;
            }
        }
        return result;
    }
}
