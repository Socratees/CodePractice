package leetcode2.p76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 双指针，滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String res = "";
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> bitMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (bitMap.containsKey(c)) {
                int val = bitMap.get(c);
                bitMap.put(c, val + 1);
            } else {
                bitMap.put(c, 1);
            }
        }

        int l = 0, r = 0;
        while (r < s.length()) {
            char sChar = s.charAt(r);
            if (bitMap.containsKey(sChar)) {
                bitMap.put(sChar, bitMap.get(sChar) - 1);
            }
            r++;
            while (isSatisfied(bitMap)) {
                if (r - l < minLen) {
                    res = s.substring(l, r);
                    minLen = r - l;
                }
                //左指针弹出窗口
                char lChar = s.charAt(l);
                if(bitMap.containsKey(lChar)){
                    bitMap.put(lChar, bitMap.get(lChar) + 1);
                }
                l++;
            }
        }
        return res;
    }

    public boolean isSatisfied(Map<Character, Integer> bitMap) {
        for (Map.Entry<Character, Integer> entry : bitMap.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minWindow("ADOBECODEBANC","ABC");
    }
}
