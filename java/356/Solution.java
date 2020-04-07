public class Solution {
    public boolean isReflected(int[][] points) {
        if (points.length < 2) {
            return true;
        }
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
        }
        double midX = ((double) minX + maxX) / 2;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[0] != point2[0]) {
                    return Integer.compare(point1[0], point2[0]);
                } else {
                    return point1[0] <= midX ? Integer.compare(point1[1], point2[1]) : Integer.compare(point2[1], point1[1]);
                }
            }
        });
        for (int i = 0, j = points.length - 1; i <= j; i++, j--) {
            if (points[i][0] - minX != maxX - points[j][0] || (points[i][0] - minX != maxX - points[i][0] && points[i][1] != points[j][1])) {
                return false;
            }
        }
        return true;
    }
}
