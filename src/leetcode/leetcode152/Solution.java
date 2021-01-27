package leetcode.leetcode152;

import java.util.Arrays;

public class Solution {
    /*
    * https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
    * 动态规划，永远滴神！
    * */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int result = max[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            result = Math.max(result,max[i]);
        }
        return result;
    }
}
