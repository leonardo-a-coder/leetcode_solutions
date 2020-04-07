public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int haveStock = Math.max(-prices[0], -prices[1]);
        int[] notHaveStock = new int[2];
        notHaveStock[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            haveStock = Math.max(haveStock, notHaveStock[0] - prices[i]);
            notHaveStock[0] = notHaveStock[1];
            notHaveStock[1] = Math.max(haveStock + prices[i], notHaveStock[1]);
        }
        return notHaveStock[1];
    }
