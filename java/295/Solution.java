public class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i2, i1);
        }
    });
    private double median;

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (!minHeap.isEmpty()) {
            if (num <= median) {
                maxHeap.add(num);
                if (maxHeap.size() - minHeap.size() == 2) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(num);
                if (minHeap.size() - maxHeap.size() == 2) {
                    maxHeap.add(minHeap.poll());
                }
            }
            if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
                median = ((double) minHeap.peek() + maxHeap.peek()) / 2;
            } else {
                median = minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
            }
        } else {
            minHeap.add(num);
            median = num;
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
