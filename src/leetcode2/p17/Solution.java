package leetcode2.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<String, String> mapping = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack(String digits, int index, StringBuilder sb) {
        if (index >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = mapping.get(digits.substring(index, index + 1));
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
