public class MovingAverage {
    private int windowSize;
    private Queue<Integer> queue;
    private double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        windowSize = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if (queue.size() == windowSize) {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
