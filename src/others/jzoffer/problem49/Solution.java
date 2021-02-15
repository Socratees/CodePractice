package others.jzoffer.problem49;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public int nthUglyNumber(int n) {
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        int last = nums.get(nums.size() - 1);
//        int nextNumber = 0;
//        while (nums.size() < n) {
//            last = nums.get(nums.size() - 1);
//            for (int i : nums) {
//                if (i * 2 > last) {
//                    nextNumber = i * 2;
//                    break;
//                }
//            }
//            for (int i : nums) {
//                if (i * 3 > last) {
//                    nextNumber = Math.min(nextNumber, i * 3);
//                    break;
//                }
//            }
//            for (int i : nums) {
//                if (i * 5 > last) {
//                    nextNumber = Math.min(nextNumber, i * 5);
//                    break;
//                }
//            }
//            nums.add(nextNumber);
//        }
//        return nums.get(n - 1);
//
//    }

    //三指针法+动态规划
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int dp2 = 0, dp3 = 0, dp5 = 0;
        int nextNumber = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[dp2] * 2, Math.min(dp[dp3] * 3, dp[dp5] * 5));
            if (dp[dp2] * 2 == dp[i]) {
                dp2++;
            }
            if (dp[dp3] * 3 == dp[i]) {
                dp3++;
            }
            if (dp[dp5] * 5 == dp[i]) {
                dp5++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(1500));
    }
}
