public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int index = 0;
        while (index < intervals.size()) {
            Interval cur = intervals.get(index);
            if (cur.end < newInterval.start) {
                result.add(cur);
            } else if (newInterval.end < cur.start) {
                result.add(newInterval);
                break;
            } else {
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            }
            index++;
        }
        if (index == intervals.size()) {
            result.add(newInterval);
        } else {
            while (index < intervals.size()) {
                result.add(intervals.get(index++));
            }
        }
        return result;
    }
}
