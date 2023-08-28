package leetcode2.p205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        StringBuilder sStr = new StringBuilder();
        StringBuilder tStr = new StringBuilder();
        int sCount = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = sMap.getOrDefault(c, 0);
            if (value != 0) {
                sStr.append(value);
            } else {
                sStr.append(sCount);
                sMap.put(c, sCount);
                sCount++;
            }
        }
        int tCount = 1;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int value = tMap.getOrDefault(c, 0);
            if (value != 0) {
                tStr.append(value);
            } else {
                tStr.append(tCount);
                tMap.put(c, tCount);
                tCount++;
            }
        }
        return sStr.toString().equals(tStr.toString());
    }
}
