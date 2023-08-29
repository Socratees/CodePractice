package leetcode2.p228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            while (r + 1 < nums.length && nums[r + 1] - nums[r] == 1) {
                r++;
            }
            if (r != l) {
                res.add(nums[l] + "->" + nums[r]);
            } else {
                res.add(String.valueOf(nums[r]));
            }
            r++;
            l = r;
        }
        return res;
    }
}
