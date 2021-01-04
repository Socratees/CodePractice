package leetcode.leetcode48;

public class Solution {
    /**
     * 矩阵的顺时针旋转等价于先转置，再左右镜像对称
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int tmp = 0;
        //先转置矩阵
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

        //再左右镜像对称
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                if (matrix[i][j] != matrix[i][length - j - 1]) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][length - j - 1];
                    matrix[i][length - j - 1] = tmp;
                }
            }
        }
    }
}
