package others.jzoffer.problem47;

public class Solution {
    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = (j == 0) ? grid[i][j] : (dp[i][j - 1] + grid[i][j]);
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
