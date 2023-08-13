package leetcode2.p394;

import java.util.Objects;
import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                stack.push(String.valueOf(c));
            } else if (c == '[') {
                stack.push(String.valueOf(c));
            } else if (c == ']') {
                String sb = "";
                while (!stack.isEmpty() && Character.isAlphabetic(stack.peek().charAt(0))) {
                    sb = stack.pop().concat(sb);
                }
                //弹出'['
                if ("[".equals(stack.peek())) {
                    stack.pop();
                }

                int number = 0;
                int weight = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    number += (stack.pop().charAt(0) - '0') * weight;
                    weight *= 10;
                }
                if (number > 1) {
                    String tmp = new String(sb);
                    for (int j = 0; j < number - 1; j++) {
                        sb  = sb.concat(tmp);
                    }
                }
                stack.push(sb);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop().concat(res);
        }
        return res;
    }


}
