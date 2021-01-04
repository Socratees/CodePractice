package leetcode.leetcode279;

public class Solution {
    /*这里使用动态规划来做。时间复杂度O(nlogn)，空间复杂度O(n)。代码非常精简
    定义一个函数f(n)表示我们要求的解。f(n)的求解过程为：
    f(n) = 1 + min{
        f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) //(k为满足k^2<=n的最大的k)
    }
    */
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int min = 0;
        for (int i = 3; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = 1 + min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
