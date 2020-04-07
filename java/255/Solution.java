public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int index = -1;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < min) {
                return false;
            }
            while (index >= 0 && preorder[index] < preorder[i]) {
                min = preorder[index--];
            }
            preorder[++index] = preorder[i];
        }
        return true;
    }
}
