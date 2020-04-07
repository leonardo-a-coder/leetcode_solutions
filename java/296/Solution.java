public class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] xArr = new int[m];
        int[] yArr = new int[n];
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    xArr[i]++;
                    yArr[j]++;
                    total++;
                }
            }
        }
        int xMid = getMid(xArr, total);
        int yMid = getMid(yArr, total);
        return countDistance(xArr, xMid) + countDistance(yArr, yMid);
    }
    
    private int getMid(int[] arr, int total) {
        int left = 0;
        int right = total;
        for (int i = 0; i < arr.length; i++) {
            left += arr[i];
            right -= arr[i];
            if (left >= right) {
                return i;
            }
        }
        return 0;
    }
    
    private int countDistance(int[] arr, int mid) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] * Math.abs(i - mid);
        }
        return result;
    }
}
