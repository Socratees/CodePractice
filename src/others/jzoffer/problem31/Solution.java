package others.jzoffer.problem31;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < popped.length; i++) {
            if (stack.isEmpty() || stack.peek() != popped[i]) {
                for (int j = index; j < pushed.length; j++) {
                    stack.push(pushed[j]);
                    if (pushed[j] == popped[i]) {
                        index = j + 1;
                        break;
                    }
                }
                if (stack.peek() == popped[i]) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (stack.peek() == popped[i]) {
                stack.pop();
            }
        }
        return true;
    }
}
