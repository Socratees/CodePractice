package leetcode2.p383;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            int value = map.getOrDefault(magazine.charAt(i), 0);
            map.put(magazine.charAt(i), value + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int value = map.getOrDefault(c, 0);
            if (value == 0) {
                return false;
            }
            map.put(c, value - 1);
        }
        return true;
    }
}
