package others.jzoffer.problem42;

public class Solution {
//    public int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int max = dp[0];
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = (dp[i-1]>0)?dp[i-1]+nums[i]:nums[i];
//            max = Math.max(max,dp[i]);
//        }
//        return max;
//    }

    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(preSum<=0){
                preSum = nums[i];
            }else {
                preSum +=nums[i];
            }

            max = (i==0)?preSum:Math.max(max,preSum);
        }
        return max;
    }

}
