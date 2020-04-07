public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] nodes = new int[n];
        int[] count = new int[n];
        int result = n;
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
        Arrays.fill(count, 1);
        for (int[] edge : edges) {
            if (union(nodes, count, edge[0], edge[1])) {
                result--;
            }
        }
        return result;
    }
    
    private boolean union(int[] nodes, int[] count, int i, int j) {
        int rootI = root(nodes, i);
        int rootJ = root(nodes, j);
        if (rootI != rootJ) {
            if (count[rootI] < count[rootJ]) {
                nodes[rootI] = rootJ;
                count[rootJ] += count[rootI];
            } else {
                nodes[rootJ] = rootI;
                count[rootI] += count[rootJ];
            }
            return true;
        } else {
            return false;
        }
    }
    
    private int root(int[] nodes, int i) {
        while (i != nodes[i]) {
            nodes[i] = nodes[nodes[i]];
            i = nodes[i];
        }
        return i;
    }
}
