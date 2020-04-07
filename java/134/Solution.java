public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int start = 0;
        int cur = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            cur += diff;
            total += diff;
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
