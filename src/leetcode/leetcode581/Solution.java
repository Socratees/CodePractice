package leetcode.leetcode581;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] newNum = nums.clone();
        Arrays.sort(newNum);
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length) {
            if (nums[left] != newNum[left]) {
                break;
            }
            left++;
        }
        while (right >= 0) {
            if (nums[right] != newNum[right]) {
                break;
            }
            right--;
        }
        return (right >= left) ? right - left + 1 : 0;
    }
}
