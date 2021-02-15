package others.jzoffer.problem48;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //维护一个动态规划数组和一个hashmap<Character,Integer>
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int[] dp = new int[s.length()];
//        dp[0] = 1;
//        int max = 1;
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put(s.charAt(0), 0);
//        for (int i = 1; i < dp.length; i++) {
//            if (map.containsKey(s.charAt(i)) && dp[i - 1] >= i - map.get(s.charAt(i))) {
//                dp[i] = i - map.get(s.charAt(i));
//            } else {
//                dp[i] = dp[i - 1] + 1;
//            }
//            max = Math.max(max, dp[i]);
//            map.put(s.charAt(i), i);
//        }
//        return max;
//    }

    //滑动窗口，维护一个不重复的set
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, left = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, i - left + 1);
            set.add(s.charAt(i));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcd"));
    }
}
