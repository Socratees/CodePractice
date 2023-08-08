package leetcode2.p34;

public class Solution {
    /**
     * 注意左右边界的差别
     * nums[mid]=target时，搜左边界移动右指针，搜右边界移动左指针！！！
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int leftEdge = findEdge(nums, target, true);
        int rightEdge = findEdge(nums,target,false);
        return new int[]{leftEdge, rightEdge};
    }

    /**
     *
     * @param nums
     * @param target
     * @param flag true表示搜索左边界，false表示搜索右边界
     * @return
     */
    public int findEdge(int[] nums, int target, boolean flag) {
        int start = 0, end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                res = mid;
                //关键所在
                if (flag) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return res;
    }

}
