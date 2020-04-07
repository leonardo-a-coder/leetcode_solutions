public class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[][] matrix = new int[m][n];
        int[] islands = new int[positions.length];
        int[] count = new int[positions.length];
        int numIslands = 0;
        
        for (int i = 0; i < islands.length; i++) {
            islands[i] = i;
        }
        Arrays.fill(count, 1);
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (matrix[x][y] > 0) {
                result.add(numIslands);
                continue;
            }
            matrix[x][y] = i + 1;
            numIslands++;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > 0 && union(islands, count, i, matrix[newX][newY] - 1)) {
                    numIslands--;
                }
            }
            result.add(numIslands);
        }
        return result;
    }
    
    private boolean union(int[] arr, int[] count, int i, int j) {
        int iRoot = root(arr, i);
        int jRoot = root(arr, j);
        if (iRoot != jRoot) {
            if (count[iRoot] <= count[jRoot]) {
                arr[iRoot] = jRoot;
                count[jRoot] += count[iRoot];
                count[iRoot] = 0;
            } else {
                arr[jRoot] = iRoot;
                count[iRoot] += count[jRoot];
                count[jRoot] = 0;
            }
            return true;
        } else {
            return false;
        }
    }
    
    private int root(int[] arr, int i) {
        while (arr[i] != i) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
}
