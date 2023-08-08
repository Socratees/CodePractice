package leetcode2.p131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[][] helper;

    public List<List<String>> partition(String s) {
        helper = new boolean[s.length()][s.length()];
        for (int i = 0; i < helper.length; i++) {
            Arrays.fill(helper[i], true);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                helper[i][j] = (s.charAt(i) == s.charAt(j)) && helper[i + 1][j - 1];
            }
        }
        dfs(s, 0, new ArrayList<>());
        return res;
    }

    public void dfs(String s, int index, List<String> tmp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (helper[index][i]) {
                tmp.add(s.substring(index, i));
                dfs(s, index + 1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
