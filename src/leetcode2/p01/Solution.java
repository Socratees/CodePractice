package leetcode2.p01;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 一遍遍历，用一个map记录{value:index}，
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(target - nums[i])){
                return new int[]{index.get(target - nums[i]), i};
            }
            index.put(nums[i], i);
        }
        return null;
    }
}
