package leetcode.leetcode200;

import java.util.Stack;

public class Solution {
    public int islands = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] isVisited = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    islands++;
                    //深度优先遍历
                    Stack<Point> stack = new Stack<>();
                    stack.push(new Point(i, j));
                    isVisited[i][j] = true;
                    while (!stack.isEmpty()) {
                        Point p = stack.pop();
                        isVisited[p.row][p.col] = true;
                        //上面
                        if (p.row - 1 >= 0 && grid[p.row - 1][p.col] == '1' && !isVisited[p.row - 1][p.col]) {
                            stack.push(new Point(p.row - 1, p.col));
                        }
                        //下面
                        if (p.row + 1 < rowLength && grid[p.row + 1][p.col] == '1' && !isVisited[p.row + 1][p.col]) {
                            stack.push(new Point(p.row + 1, p.col));
                        }
                        //左边
                        if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == '1' && !isVisited[p.row][p.col - 1]) {
                            stack.push(new Point(p.row, p.col - 1));
                        }
                        //右边
                        if (p.col + 1 < colLength && grid[p.row][p.col + 1] == '1' && !isVisited[p.row][p.col + 1]) {
                            stack.push(new Point(p.row, p.col + 1));
                        }
                    }
                }
            }
        }


        return islands;
    }

    public class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
