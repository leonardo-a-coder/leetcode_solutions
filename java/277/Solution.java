public class Solution extends Relation {
    public int findCelebrity(int n) {
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (knows(start, end)) {
                start++;
            } else {
                end--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != start && (!knows(i, start) || knows(start, i))) {
                return -1;
            }
        }
        return start;
    }
}
