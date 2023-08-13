package leetcode2.p84;

import java.util.Stack;

public class Solution {
    /**
     * 单调栈的经典应用，在leetcode739题的基础之上的变形
     * 在一维数组中向左或向右找第一个大于/小于自己的数，就是单调栈的应用场景
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> leftToRight = new Stack<>();
        Stack<Integer> rightToLeft = new Stack<>();
        int[] left2Right = new int[heights.length];
        int[] right2Left = new int[heights.length];
        for (int i = 0, j = heights.length - 1; i < heights.length; i++, j--) {
            while (!leftToRight.isEmpty() && heights[i] < heights[leftToRight.peek()]) {
                left2Right[leftToRight.peek()] = i - leftToRight.peek();
                leftToRight.pop();
            }
            leftToRight.push(i);

            while (!rightToLeft.isEmpty() && heights[j] < heights[rightToLeft.peek()]) {
                right2Left[rightToLeft.peek()] = rightToLeft.peek() - j;
                rightToLeft.pop();
            }
            rightToLeft.push(j);
        }

        int maxArea = 0;
        for (int i = 0; i < left2Right.length; i++) {
            int leftDist = left2Right[i] == 0 ? heights.length - i : left2Right[i];
            int rightDist = right2Left[i] == 0 ? i + 1 : right2Left[i];
            int area = (leftDist + rightDist - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
