package leetcode2.p05;

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i >= j) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        res = s.substring(i, j + 1);
                        maxLen = j-i+1;
                    }
                    continue;
                }
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && j - i + 1 > maxLen){
                    res = s.substring(i, j + 1);
                    maxLen = j-i+1;
                }
            }
        }
        return res;
    }
}
