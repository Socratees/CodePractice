package leetcode.leetcode807;

public class leetcode807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] x = new int[grid[0].length];
        int[] y = new int[grid.length];

        int max = 0;
        for (int i = 0; i < x.length; i++) {
            max = 0;
            for (int j = 0; j < grid.length; j++) {
                x[i] = Math.max(max, grid[j][i]);
                max = x[i];
            }
        }

        for(int i = 0; i < y.length; i++){
            max = 0;
            for(int j = 0; j < grid[i].length; j++){
                y[i] = Math.max(max, grid[i][j]);
                max = y[i];
            }
        }

//        int[][] result = new int[grid.length][grid[0].length];
        int add = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int m = Math.min(y[i], x[j]);
                if(m > grid[i][j]){
                    add = add + (m - grid[i][j]);
                }
            }
        }
        return add;
    }
}
