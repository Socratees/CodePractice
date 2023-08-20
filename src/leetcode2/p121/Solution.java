package leetcode2.p121;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1] + profit[i - 1];
            profit[i] = Math.max(tmp, 0);
            res = Math.max(res, profit[i]);
        }
        return res;
    }
}
