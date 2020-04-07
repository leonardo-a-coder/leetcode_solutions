public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start != i2.start ? Integer.compare(i1.start, i2.start) : Integer.compare(i1.end, i2.end);
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (end < cur.start) {
                result.add(new Interval(start, end));
                start = cur.start;
                end = cur.end;
            } else {
                end = Math.max(end, cur.end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
