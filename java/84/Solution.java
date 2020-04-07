public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int peakIndex = stack.pop();
                result = Math.max(result, heights[peakIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int peakIndex = stack.pop();
            result = Math.max(result, heights[peakIndex] * (stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1));
        }
        return result;
    }
}
