package leetcode.leetcode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, nums);
        return result;
    }

    public void backtrack(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int n : nums) {
            if (!list.contains(n)) {
                list.add(n);
                backtrack(list, nums);
                list.remove(list.size() - 1);
            }

        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        leetcode46 l = new leetcode46();
        l.permute(nums);
        System.out.println(l.result);
    }
}
