package leetcode.leetcode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode46 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        if (len == 0 || nums == null) {
            return res;
        }
        exchange(nums, 0, len);
        return res;
    }

    public  void exchange(int[] nums, int i, int len) {
        if (i == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < len; k++) {
                list.add(nums[k]);
            }
            res.add(list);
            return;
        }

        for (int j = i; j < len; j++) {
            swap(nums, i, j);
            exchange(nums, i + 1, len);
            swap(nums, i, j);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        leetcode46 l = new leetcode46();

        l.permute(nums);
        System.out.println(l.res);
    }
}
