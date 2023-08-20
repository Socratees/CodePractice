package leetcode2.p994;

public class Solution {
    int min = Integer.MAX_VALUE;

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, visited, i, j, 0);
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
                res = Math.min(res, grid[i][j]);
            }
        }
        return -res;
    }

    public void dfs(int[][] grid, boolean[][] visited, int row, int col, int minutes) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (grid[row][col] == 1) {
            if (minutes < 0) {
                grid[row][col] = minutes;
                minutes--;
            }
        } else if (grid[row][col] == 2) {
            minutes = -1;
        } else if (grid[row][col] < 0) {
            grid[row][col] = Math.max(grid[row][col], minutes);
            minutes = grid[row][col] - 1;
        }
        min = grid[row][col] < 0 ? Math.min(min, grid[row][col]) : min;
        dfs(grid, visited, row - 1, col, minutes);
        dfs(grid, visited, row + 1, col, minutes);
        dfs(grid, visited, row, col - 1, minutes);
        dfs(grid, visited, row, col + 1, minutes);
    }
}
