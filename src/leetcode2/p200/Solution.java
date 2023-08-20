package leetcode2.p200;

public class Solution {
    public int islandNum = 0;

    /**
     * dfs的灵魂在于访问标记数组visited
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //靠访问标记数组来决定isLandNum是否加一
                if (grid[i][j] != '0' && !visited[i][j]) {
                    islandNum++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return islandNum;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (grid[row][col] != '0') {
            grid[row][col] = (char) ('0' + islandNum);
            dfs(grid, visited, row + 1, col);
            dfs(grid, visited, row - 1, col);
            dfs(grid, visited, row, col + 1);
            dfs(grid, visited, row, col - 1);
        }
    }
}
