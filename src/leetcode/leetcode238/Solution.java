package leetcode.leetcode238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightProduct[i] = product;
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftProduct[i] * rightProduct[i];
        }
        return nums;
    }
}
