package leetcode.leetcode22;

import java.util.ArrayList;
import java.util.List;

/*
 *  三个原则：
 *  1. 左括号没用完之前都可以随便用
 *  2. 右括号数量必须小于左括号的时候才能用
 *  3. 右括号用完，代码结束
 */
public class leetcode22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper("", n, 0 , 0, list);
        return list;
    }

    public static void helper(String curr, int n, int left, int right, List<String> result){
        if(right == n){
            result.add(curr);
            return;
        }

        if(left < n){
            helper(curr + "(", n , left + 1, right, result);
        }

        if(right < left){
            helper( curr + ")", n, left, right+ 1, result);
        }


    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
