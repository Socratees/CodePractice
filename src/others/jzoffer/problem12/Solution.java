package others.jzoffer.problem12;

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = true;
                    if (backtrack(board, word.substring(1), i, j, isVisited)) {
                        return true;
                    } else {
                        isVisited[i][j] = false;//回溯
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, boolean[][] isVisited) {
        if (word.length() == 0) {
            return true;
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int thisRow = row + direction[0];
            int thisCol = col + direction[1];
            if (thisRow >= 0 && thisRow < board.length && thisCol >= 0 && thisCol < board[0].length
                    && board[thisRow][thisCol] == word.charAt(0)) {
                if (isVisited[thisRow][thisCol]) {
                    continue;
                }
                isVisited[thisRow][thisCol] = true;
                if (backtrack(board, word.substring(1), thisRow, thisCol, isVisited)) {
                    return true;
                } else {
                    isVisited[thisRow][thisCol] = false;//回溯
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(solution.exist(board, "ABCF"));;
    }
}
