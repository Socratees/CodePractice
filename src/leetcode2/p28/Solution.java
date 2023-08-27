package leetcode2.p28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() < haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int m = i;
            int n = 0;
            while (n<needle.length() && haystack.charAt(m) == needle.charAt(n)) {
                m++;
                n++;
            }
            if (n == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
