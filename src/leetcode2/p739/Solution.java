package leetcode2.p739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
