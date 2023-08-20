package leetcode2.p189;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = k % nums.length;
        if (len == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, len - 1);
        reverse(nums, len, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
