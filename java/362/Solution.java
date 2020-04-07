public class HitCounter {
    private int[] buckets;
    private int prev;
    private int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        buckets = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        clearStaleData(timestamp);
        prev = timestamp;
        buckets[(timestamp - 1) % buckets.length]++;
        count++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        clearStaleData(timestamp);
        prev = timestamp;
        return count;
    }
    
    private void clearStaleData(int cur) {
        if (cur - prev >= buckets.length) {
            count = 0;
            Arrays.fill(buckets, 0);
        } else {
            prev++;
            int index = (prev - 1) % buckets.length;
            while (prev <= cur) {
                count -= buckets[index];
                buckets[index] = 0;
                prev++;
                index++;
                if (index == buckets.length) {
                    index = 0;
                }
            }
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
