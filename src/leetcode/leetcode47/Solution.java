package leetcode.leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //排序是为了后面的去重
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        backtrack(list, nums, isVisited);
        return result;
    }

    public void backtrack(List<Integer> list, int[] nums, boolean[] isVisited) {
        // 列表长度达到数组长度时，拷贝列表到结果列表中
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            // 如果数组相连元素相等，没有先访问后面的元素，就不会存在重复，这个点真的要好好理解！！
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            isVisited[i] = true;

            backtrack(list, nums, isVisited);

            list.remove(list.size() - 1);
            isVisited[i] = false;

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(new int[]{0, 0, 1, 1});
        System.out.println(res);
    }
}
