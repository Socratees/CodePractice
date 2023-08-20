package leetcode2.p560;

public class Solution {
    /**
     * 前缀数组
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k){
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
