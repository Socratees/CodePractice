package leetcode2.p80;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int bitCount = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                bitCount++;
                continue;
            }
            if (nums[i] != nums[i - 1]) {
                bitCount = 1;
            } else {
                if (bitCount < 2) {
                    bitCount++;
                } else {
                    deleteIndex(nums, i);
                    len--;
                    i--;
                }
            }
        }
        return len;
    }

    public void deleteIndex(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }
    }
}
