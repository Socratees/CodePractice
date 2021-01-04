package leetcode.leetcode283;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int count = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (count > 0) {
                    tmp = nums[i];
                    nums[i] = nums[i - count];
                    nums[i - count] = tmp;
                }

            }
        }

    }
}
