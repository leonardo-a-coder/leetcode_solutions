public class Solution {
    public int trap(int[] height) {
        int result = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        
        int max = 0;
        for (int i = 0; i < len; i++) {
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }
        
        for (int i = 1; i < len - 1; i++) {
            result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return result;
    }
}
