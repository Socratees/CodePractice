package leetcode.leetcode327;

public class Solution {
    //前缀数组加归并排序！
    //https://leetcode-cn.com/problems/count-of-range-sum/solution/qu-jian-he-de-ge-shu-by-leetcode-solution/
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return merge(preSum, 0, preSum.length - 1, lower, upper);
    }

    public int merge(long[] nums, int left, int right, int lower, int upper) {
        if (right <= left) {
            return 0;
        }
        int result = 0;
        int mid = (left + right) / 2;
        int leftCount = merge(nums, left, mid, lower, upper);
        int rightCount = merge(nums, mid + 1, right, lower, upper);
        int p1 = left, p2 = mid + 1, p3 = mid + 1;
        long[] arr = new long[right - left + 1];
        int index = 0;
        int l = left, r = mid + 1;

        for (; p1 <= mid; p1++) {
//            p2 = p3 = mid + 1;
            while (p2 <= right && nums[p2] < nums[p1] + lower) {
                p2++;
            }
            while (p3 <= right && nums[p3] <= nums[p1] + upper) {
                p3++;
            }
            result += p3 - p2;
        }

        //合并两个排序数组
        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                arr[index++] = nums[l];
                l++;
            } else {
                arr[index++] = nums[r];
                r++;
            }
        }
        while (l <= mid) {
            arr[index++] = nums[l];
            l++;
        }
        while (r <=right) {
            arr[index++] = nums[r];
            r++;
        }
        System.arraycopy(arr, 0, nums, left, arr.length);

        return result + leftCount + rightCount;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countRangeSum(new int[]{-2, 0, 0, 2, 2, -2}, -3, 1));
    }

}
