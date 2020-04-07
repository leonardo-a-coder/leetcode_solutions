public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = m == 0 ? 0 : image[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int left = getIndex(image, 0, y, 0, m - 1, false, true);
        int right = getIndex(image, y, n - 1, 0, m - 1, false, false);
        int top = getIndex(image, 0, x, left, right, true, true);
        int bottom = getIndex(image, x, m - 1, left, right, true, false);
        return (right - left + 1) * (bottom - top + 1);
    }
    
    private int getIndex(char[][] image, int start, int end, int min, int max, boolean isRow, boolean isLow) {
        int result = isLow ? Integer.MAX_VALUE : 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasBlack(image, mid, isRow, min, max)) {
                if (isLow) {
                    result = Math.min(result, mid);
                    end = mid - 1;
                } else {
                    result = Math.max(result, mid);
                    start = mid + 1;
                }
            } else {
                if (isLow) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return result;
    }
    
    private boolean hasBlack(char[][] image, int index, boolean isRow, int min, int max) {
        return isRow ? hasBlackRow(image, index, min, max) : hasBlackCol(image, index, min, max);
    }
    
    private boolean hasBlackRow(char[][] image, int index, int min, int max) {
        for (int j = min; j <= max; j++) {
            if (image[index][j] == '1') {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasBlackCol(char[][] image, int index, int min, int max) {
        for (int i = min; i <= max; i++) {
            if (image[i][index] == '1') {
                return true;
            }
        }
        return false;
    }
}
