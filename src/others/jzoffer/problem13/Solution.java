package others.jzoffer.problem13;

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col] && getDigitSum(row) + getDigitSum(col) <= threshold) {
            visited[row][col] = true;
            return 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited) + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited) + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        } else {
            return 0;
        }
    }

    public int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(1,10,10));
    }
}
