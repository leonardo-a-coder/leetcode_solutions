public class Solution {
    public static final int[][] SKIP_LIST;
    static {
        SKIP_LIST = new int[10][10];
        SKIP_LIST[1][3] = SKIP_LIST[3][1] = 2;
        SKIP_LIST[1][7] = SKIP_LIST[7][1] = 4;
        SKIP_LIST[3][9] = SKIP_LIST[9][3] = 6;
        SKIP_LIST[7][9] = SKIP_LIST[9][7] = 8;
        SKIP_LIST[1][9] = SKIP_LIST[2][8] = SKIP_LIST[3][7] = SKIP_LIST[4][6] = SKIP_LIST[6][4] = SKIP_LIST[7][3] = SKIP_LIST[8][2] = SKIP_LIST[9][1] = 5;
    }
    
    public int numberOfPatterns(int m, int n) {
        if (m < 1 || m > 9 || n < m || n > 9) {
            return 0;
        }
        return (dfs(m, n, 0, new boolean[10], 1) << 2) + (dfs(m, n, 0, new boolean[10], 2) << 2) + dfs(m, n, 0, new boolean[10], 5);
    }
    
    private int dfs(int m, int n, int curStep, boolean[] isVisited, int curPos) {
        int result = 0;
        isVisited[curPos] = true;
        curStep++;
        if (curStep >= m) {
            result++;
        }
        if (curStep < n) {
            for (int i = 1; i <= 9; i++) {
                if (!isVisited[i] && (SKIP_LIST[curPos][i] == 0 || isVisited[SKIP_LIST[curPos][i]])) {
                    result += dfs(m, n, curStep, isVisited, i);
                }
            }
        }
        isVisited[curPos] = false;
        return result;
    }
}
