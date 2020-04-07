public class Solution {
    public boolean isSelfCrossing(int[] x) {
        for (int i = 0; i < x.length - 3; i++) {
            if (check4(x, i) || check5(x, i) || check6(x, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean check4(int[] x, int index) {
        return index + 3 < x.length && x[index] >= x[index + 2] && x[index + 3] >= x[index + 1];
    }
    
    private boolean check5(int[] x, int index) {
        return index + 4 < x.length && x[index] + x[index + 4] >= x[index + 2] && x[index + 1] == x[index + 3];
    }
    
    private boolean check6(int[] x, int index) {
        return index + 5 < x.length && x[index] < x[index + 2] && x[index + 4] < x[index + 2] && x[index] + x[index + 4] >= x[index + 2] && x[index + 1] < x[index + 3] && x[index + 1] + x[index + 5] >= x[index + 3];
    }
}
