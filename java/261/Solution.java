public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n != edges.length + 1) {
            return false;
        }
        int[] groups = new int[n];
        int[] count = new int[n];
        for (int i = 1; i < n; i++) {
            groups[i] = i;
        }
        Arrays.fill(count, 1);
        for (int[] edge : edges) {
            if (!union(groups, count, edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean union(int[] groups, int[] count, int i, int j) {
        int rootI = root(groups, i);
        int rootJ = root(groups, j);
        if (rootI == rootJ) {
            return false;
        }
        if (count[rootI] < count[rootJ]) {
            groups[rootI] = rootJ;
            count[rootJ] += count[rootI];
        } else {
            groups[rootJ] = rootI;
            count[rootI] += count[rootJ];
        }
        return true;
    }
    
    private int root(int[] groups, int i) {
        while (groups[i] != i) {
            groups[i] = groups[groups[i]];
            i = groups[i];
        }
        return i;
    }
}
