package leetcode.leetcode84;

import java.util.Stack;

public class Solution {
    //单调栈法
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
}
