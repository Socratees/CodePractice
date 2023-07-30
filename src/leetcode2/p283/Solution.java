package leetcode2.p283;

public class Solution {
    /**
     * 双指针大法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                while (left < right && nums[left] != 0) {
                    left++;
                }
                nums[left] = nums[right];
                if (left != right) {
                    nums[right] = 0;
                }
            }
            right++;
        }
    }
}
