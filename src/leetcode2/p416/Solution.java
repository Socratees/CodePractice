package leetcode2.p416;

public class Solution {
    /**
     * 转化为0-1背包问题, dp[i][j],i表示物品序号，j表示背包大小
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = nums[i] == j;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }

                if (dp[i][target]) {
                    return true;
                }
            }
        }
        return false;
    }
}
