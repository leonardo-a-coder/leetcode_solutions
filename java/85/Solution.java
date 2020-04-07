public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int result = 0;
        int[] height = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
                while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
                    int peakIndex = stack.pop();
                    result = Math.max(result, height[peakIndex] * (stack.isEmpty() ? j : j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int peakIndex = stack.pop();
                result = Math.max(result, height[peakIndex] * (stack.isEmpty() ? n : n - stack.peek() - 1));
            }
        }
        return result;
    }
}
