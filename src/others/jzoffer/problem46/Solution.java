package others.jzoffer.problem46;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //回溯法，或者动态规划
    //    String[] container = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
//            "s", "t", "u", "v", "w", "x", "y", "z"};
//    Set<String> set = new HashSet<>();
//
//    public int translateNum(int num) {
//        backtrack("", String.valueOf(num));
//        return set.size();
//    }
//
//    public void backtrack(String result, String num) {
//        if (num.length() == 0) {
//            set.add(result);
//            return;
//        }
//
//        result = result.concat(container[(int) num.charAt(0) - (int) '0']);
//        backtrack(result, num.substring(1));
//        result = result.substring(0, result.length() - 1);
//
//        if (num.length() > 1 && !num.startsWith("0")) {
//            int next = Integer.parseInt(num.substring(0, 2));
//            if (next < 26) {
//                result = result.concat(container[next]);
//                backtrack(result, num.substring(2));
//                result = result.substring(0, result.length() - 1);
//            }
//        }
//
//    }
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return 1;
        }
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        int next = Integer.parseInt(numStr.substring(0, 2));
        if (!numStr.startsWith("0") && next < 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            next = Integer.parseInt(numStr.substring(i - 1, i + 1));
            dp[i] = (numStr.charAt(i - 1) != '0' && next < 26) ? (dp[i - 1] + dp[i - 2]) : dp[i - 1];
        }
        return dp[dp.length - 1];

    }
}
