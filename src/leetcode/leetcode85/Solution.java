package leetcode.leetcode85;

import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] ma = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    ma[i][j] = (int) matrix[i][j] - (int) '0';
                } else {
                    if (matrix[i][j] == '0') {
                        ma[i][j] = 0;
                    } else if(matrix[i][j] == '1') {
                        ma[i][j] = ma[i - 1][j] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < ma.length; i++) {
            max = Math.max(max, largestRectangleArea(ma[i]));
        }
        return max;

    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] leftBound = new int[heights.length];
        int[] rightBound = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftBound[i] = -1;
            } else {
                leftBound[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightBound[i] = heights.length;
            } else {
                rightBound[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxSquare = 0;
        for (int i = 0; i < heights.length; i++) {
            maxSquare = Math.max(maxSquare, heights[i] * (rightBound[i] - leftBound[i] - 1));
        }

        return maxSquare;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'}
        ,{'1','1','1','1','1'},{'1','0','0','1','0'}};
        solution.maximalRectangle(matrix);
    }
}
