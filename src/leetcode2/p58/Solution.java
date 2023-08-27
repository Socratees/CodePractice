package leetcode2.p58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean hasWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
                hasWord = true;
            } else {
                if (hasWord) {
                    break;
                }
            }
        }
        return count;
    }
}
