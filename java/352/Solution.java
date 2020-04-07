public class SummaryRanges {
    List<Interval> list;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        list = new ArrayList<>();
    }
    
    public void addNum(int val) {
        int pre = searchPre(val);
        int suc = pre == list.size() - 1 ? -1 : pre + 1;
        if (pre >= 0 && suc >= 0 && val + 1 == list.get(suc).start && list.get(pre).end + 1 == val) {
            list.get(pre).end = list.get(suc).end;
            list.remove(suc);
        } else if (suc >= 0 && val + 1 == list.get(suc).start) {
            list.get(suc).start = val;
        } else if (pre >= 0 && list.get(pre).end + 1 >= val) {
            list.get(pre).end = Math.max(list.get(pre).end, val);
        } else {
            list.add(pre + 1, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
    
    private int searchPre(int val) {
        if (list.isEmpty() || list.get(0).start > val) {
            return -1;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid).start > val) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return list.get(end).start > val ? start : end;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
