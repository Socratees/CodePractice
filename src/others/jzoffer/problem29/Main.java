package others.jzoffer.problem29;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printClockwise(matrix, matrix.length, matrix[0].length);
    }

    public static void printClockwise(int[][] matrix, int rows, int cols) {
        if (matrix == null || rows <= 0 || cols <= 0) {
            return;
        }
        int start = 0;
        while (rows > start * 2 && cols > start * 2) {
            printCircle(matrix, rows, cols, start);
            start++;
        }

    }

    public static void printCircle(int[][] matrix, int rows, int cols, int start) {
        int endRow = rows - 1 - start;
        int endCol = cols - 1 - start;
        for (int i = start; i <= endCol; i++) {
            System.out.print(matrix[start][i] + " ");
        }
        if (endRow > start) {
            for (int i = start + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
        }

        if (endRow > start && endCol > start) {
            for (int i = endCol - 1; i >= start; i--) {
                System.out.print(matrix[endRow][i]+" ");
            }
        }

        if (endRow > start + 1 && endCol > start) {
            for (int i = endRow - 1; i > start; i--) {
                System.out.print(matrix[i][start]+" ");
            }
        }

    }
}
