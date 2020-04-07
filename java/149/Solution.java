public class Solution {
    public int maxPoints(Point[] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }
        int result = 1;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int duplicate = 1;
            for (int j = i + 1; j < len; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        duplicate++;
                    } else {
                        increment(map, Double.MAX_VALUE);
                    }
                } else {
                    double key = ((double) points[j].y - points[i].y) / ((double) points[j].x - points[i].x) + 0.0;
                    increment(map, key);
                }
            }
            result = Math.max(result, duplicate);
            for (int val : map.values()) {
                result = Math.max(result, val + duplicate);
            }
            map.clear();
        }
        return result;
    }
    
    private void increment(Map<Double, Integer> map, double key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
