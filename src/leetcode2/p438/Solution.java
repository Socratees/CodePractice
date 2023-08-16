package leetcode2.p438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        int[] pBits = new int[26];
        int[] sBits = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            pBits[p.charAt(i) - 'a']++;
        }
        String pStr = arrayToStr(pBits);

        int l = 0, r = 0;
        while (r < p.length()) {
            sBits[s.charAt(r) - 'a']++;
            r++;
        }

        while (r < s.length()) {
            String sStr = arrayToStr(sBits);
            if (sStr.equals(pStr)) {
                res.add(l);
            }

            sBits[s.charAt(r) - 'a']++;
            sBits[s.charAt(l) - 'a']--;
            l++;
            r++;
        }
        String sStr = arrayToStr(sBits);
        if (sStr.equals(pStr)) {
            res.add(l);
        }
        return res;
    }

    public String arrayToStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                char c = (char) ('a' + i);
                sb.append(c);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAnagrams("abab", "ab");
    }
}
