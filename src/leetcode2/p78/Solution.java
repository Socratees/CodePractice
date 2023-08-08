package leetcode2.p78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 这里的回溯有点特殊，注意backtrack方法里没有for循环，参数多一个index
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> tmp) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[index]);
        backtrack(nums, index + 1, tmp);
        tmp.remove(tmp.size() - 1);
        backtrack(nums, index + 1, tmp);
    }
}
