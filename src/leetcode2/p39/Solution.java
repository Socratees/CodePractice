package leetcode2.p39;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 这里参数有index，所以没有for循环，每步只有选择、不选择两种情况
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] candidates, int index, int remain, List<Integer> tmp) {
        if (remain < 0 || index >= candidates.length) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(candidates[index]);
        backtrack(candidates, index, remain - candidates[index], tmp);
        tmp.remove(tmp.size() - 1);
        backtrack(candidates, index + 1, remain, tmp);
    }

}
