package leetcode2.p152;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] maxPro = new int[nums.length];
        int[] minPro = new int[nums.length];
        maxPro[0] = nums[0];
        minPro[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxPro[i] = Math.max(nums[i], Math.max(nums[i] * maxPro[i - 1], nums[i] * minPro[i - 1]));
            minPro[i] = Math.min(nums[i], Math.min(nums[i] * maxPro[i - 1], nums[i] * minPro[i - 1]));
            res = Math.max(maxPro[i], res);
        }
        return res;
    }
}
