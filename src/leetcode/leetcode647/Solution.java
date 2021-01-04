package leetcode.leetcode647;

public class Solution {

    /*
     * 中心拓展法计数回文子串
     * */
    public int num = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);//奇数情况，中心为i
            count(s, i, i + 1);//偶数情况，中心为i和i+1
        }
        return num;
    }

    public void count(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            num++;
            left--;
            right++;
        }
    }
}
