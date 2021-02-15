package others.jzoffer.problem63;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }
}
