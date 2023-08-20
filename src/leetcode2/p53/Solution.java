package leetcode2.p53;

public class Solution {

    /**
     * 动态规划，状态转移方程: dp[i] = max(dp[i], nums[i]+dp[i-1])
     *
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int res = nums[0];
//        for(int i=1;i<nums.length;i++){
//            nums[i] = Math.max(nums[i], nums[i]+nums[i-1]);
//            res = Math.max(res, nums[i]);
//        }
//        return res;
//    }

    /**
     * 对于一个区间 [l,r][l,r][l,r]，我们可以维护四个量：
     * lSum 表示 [l,r]内以l为左端点的最大子段和
     * rSum 表示 [l,r]内以r为右端点的最大子段和
     * mSum 表示 [l,r]内的最大子段和
     * iSum 表示 [l,r]的区间和
     */
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }
        int mid = (l + r) / 2;
        Status lInfo = getInfo(nums, l, mid);
        Status rInfo = getInfo(nums, mid + 1, r);
        return pushUp(lInfo, rInfo);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
