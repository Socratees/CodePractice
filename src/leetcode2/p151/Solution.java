package leetcode2.p151;

import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        Stack<String> stack = new Stack<>();
        boolean notSpace = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && notSpace) {
                stack.push(sb.toString());
                notSpace = false;
                sb = new StringBuilder();
            } else if (c != ' ') {
                sb.append(c);
                if (!notSpace) {
                    notSpace = true;
                }
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            res.append(" ");
        }
        return res.toString().trim();
    }
}
