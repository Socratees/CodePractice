package leetcode2.p392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];

        for (int i = 0; i <= t.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j];
            }
        }
        return dp[t.length()][s.length()];
    }
}
