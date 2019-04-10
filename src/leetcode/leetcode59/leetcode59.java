package leetcode.leetcode59;

public class leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int state = 0;
        int row = 0;
        int colomn = 0;

        for (int i = 0; i < n * n; i++) {
            result[row][colomn] = i + 1;
            if (state == 0) {
                if (colomn < n - 1 && result[row][colomn + 1] == 0) {
                    colomn++;
                } else {
                    state = 1;
                    row++;
                }
                continue;
            }

            if (state == 1) {
                if (row < n - 1 && result[row + 1][colomn] == 0) {
                    row++;
                } else {
                    state = 2;
                    colomn--;
                }
                continue;
            }

            if (state == 2) {
                if (colomn > 0 && result[row][colomn - 1] == 0) {
                    colomn--;
                } else {
                    state = 3;
                    row--;
                }
                continue;
            }
            if (state == 3) {
                if (row > 0 && result[row - 1][colomn] == 0) {
                    row--;
                } else {
                    state = 0;
                    colomn++;
                }
                continue;
            }

        }
        return result;
    }


}
