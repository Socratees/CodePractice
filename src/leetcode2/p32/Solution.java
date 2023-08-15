package leetcode2.p32;


import java.util.Stack;

public class Solution {
    /**
     * 动态规划，可惜这种方法超时...
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i > j) {
                    dp[i][j] = true;
                    continue;
                } else if (i < j) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == '(' && s.charAt(j) == ')';
                    for (int k = i + 1; k < j; k++) {
                        if (dp[i][k] && dp[k + 1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                    if (dp[i][j]) {
                        res = Math.max(res, j - i + 1);
                    }
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {

            }
        }
        return res;
    }

    /**
     * 对于遇到的每个 ‘(’，我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’，我们先弹出栈顶元素表示匹配了当前右括号：
     *  如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     *  如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int peek = stack.isEmpty() ? -1 : stack.peek();
                    res = Math.max(res, i - peek);
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }

}
