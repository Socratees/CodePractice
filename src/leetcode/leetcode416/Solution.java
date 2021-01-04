package leetcode.leetcode416;

import java.util.Arrays;

public class Solution {
    //0-1背包问题
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 1; j--) {
                if (j - nums[i] >= 0 && dp[j - nums[i]]) {
                   dp[j] = true;
                }
            }
        }

        return dp[sum];

    }


}
