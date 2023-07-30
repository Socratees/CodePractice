package leetcode2.p128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * O(n)复杂度
     * 用哈希表存储每个端点值对应连续区间的长度
     * 若数已在哈希表中：跳过不做处理
     * 若是新数加入：
     *  取出其左右相邻数已有的连续区间长度 left 和 right
     *  计算当前数的区间长度为：cur_length = left + right + 1
     *  根据 cur_length 更新最大长度 max_length 的值
     *  更新区间两端点的长度值
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> helper = new HashMap<>();
        int maxLen = 0;
        for (int n : nums) {
            if(helper.containsKey(n)){
                continue;
            }
            int left = helper.getOrDefault(n - 1, 0);
            int right = helper.getOrDefault(n + 1, 0);
            int len = left + right + 1;
            helper.put(n - left, len);
            helper.put(n + right, len);
            helper.put(n, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
