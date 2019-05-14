package leetcode.leetcode931;

public class leetcode931 {
    public static int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < A[0].length; i++) {
            sum = getMinSum(A, 0, i);
            min = (min > sum) ? sum : min;
        }
        return min;
    }

    public static int getMinSum(int[][] A, int i, int j) {
        if (i == A.length - 1) {
            return A[i][j];
        } else if (j == 0) {
            return A[i][j] + Math.min(getMinSum(A, i + 1, j), getMinSum(A, i + 1, j + 1));
        } else if (j == A[0].length - 1) {
            return A[i][j] + Math.min(getMinSum(A, i + 1, j - 1), getMinSum(A, i + 1, j));
        } else {
            int m = Math.min(getMinSum(A, i + 1, j - 1), getMinSum(A, i + 1, j));
            m = (m < getMinSum(A, i + 1, j + 1)) ? m : getMinSum(A, i + 1, j + 1);
            return A[i][j] + m;
        }
    }


}
