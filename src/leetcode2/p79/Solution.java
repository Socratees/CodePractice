package leetcode2.p79;

public class Solution {
    /**
     * 回溯记得撤销操作不能少！！
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] visited = new int[board.length][board[0].length];
                if (backtrack(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, int row, int col, int[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col >= board[0].length || col < 0 || visited[row][col] == 1) {
            return false;
        }
        if (word.charAt(index) != board[row][col]) {
            return false;
        }
        visited[row][col] = 1;
        boolean flag = backtrack(board, word, index + 1, row + 1, col, visited)
                || backtrack(board, word, index + 1, row - 1, col, visited)
                || backtrack(board, word, index + 1, row, col + 1, visited)
                || backtrack(board, word, index + 1, row, col - 1, visited);
        //这一步不能少
        visited[row][col] = 0;
        return flag;
    }
}
