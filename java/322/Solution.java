public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        int min = coinChange(coins, amount, coins.length - 1, Integer.MAX_VALUE, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int coinChange(int[] coins, int amount, int index, int minCount, int curCount) {
        if (amount == 0) {
            return Math.min(minCount, curCount);
        } else if (index < 0 || curCount + amount / coins[index] >= minCount) {
            return minCount;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            minCount = Math.min(minCount, coinChange(coins, amount - i * coins[index], index - 1, minCount, curCount + i));
        }
        return minCount;
    }
}
