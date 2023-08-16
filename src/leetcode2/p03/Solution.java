package leetcode2.p03;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 移动右指针逐个加入set，若有重复，一直移动左指针
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, set.size());
            r++;
        }
        return maxLen;
    }
}
