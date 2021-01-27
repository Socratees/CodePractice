package leetcode.leetcode221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                    maxSize = Math.max(dp[i][j], maxSize);
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else if (matrix[i][j] == '1') {
                        int length = 1;
//                        boolean isSquare = true;
                        for (int k = 1; k <= dp[i - 1][j - 1]; k++) {
                            if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1') {
                                length++;
                            }else{
                                break;
                            }
                        }
                        dp[i][j] = length;
                        maxSize = Math.max(dp[i][j], maxSize);
                    }
                }

            }
        }
        return maxSize * maxSize;
    }
}
