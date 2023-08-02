package leetcode2.p46;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 经典回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        }
        int[] visited = new int[nums.length];
        backtrack(nums, visited, new LinkedList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, int[] visited, LinkedList<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.addLast(nums[i]);
            backtrack(nums, visited, tmp, res);
            visited[i] = 0;
            tmp.removeLast();
        }
    }
}
