package others.jzoffer.eight_queen;

public class Solution2 {
    int size = 8;
    int[][] chess = new int[size][size];
    int count = 0;

    //维护一个二维数组
    //回溯算法，从第一行开始backtrack()
    public void backtrack(int row) {
        if (row > 7) {
            count++;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (check(row, i)) {
                chess[row][i] = 1;
                backtrack(row + 1);
                chess[row][i] = 0;
            }
        }
    }

    public boolean check(int row, int column) {
        //检查列
        for (int i = 0; i < size; i++) {
            if (chess[i][column] == 1) {
                return false;
            }
        }

        //检查主对角线
        for (int i = row-1, j = column-1; i >= 0 && j >= 0; i--, j--) {
            if(chess[i][j] == 1){
                return false;
            }
        }

        //检查副对角线
        for (int i = row-1, j = column+1; i >= 0 && j < size; i--, j++) {
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.backtrack(0);
        System.out.println(solution2.count);
    }
}
