package leetcode.leetcode;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }

        return matchCore(s, p);
    }

    public boolean matchCore(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return matchCore(s.substring(1), p) || matchCore(s.substring(1), p.substring(2)) || matchCore(s, p.substring(2));
            } else {
                return matchCore(s, p.substring(2));
            }
        }
        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            return matchCore(s.substring(1), p.substring(1));
        }

        return false;
    }
}
