package leetcode.leetcode215;

import java.util.Arrays;

public class leetcode215 {
    public static int findKthLargest(int[] nums, int k) {
        return search(nums, 0, nums.length - 1, k);
    }

    public static int partition(int[] nums, int l, int r) {
        int temp = nums[l];
        int index = l;
        while (l < r) {
            while (l < r && nums[r] <= temp)
                r--;

            if (l < r) {
                nums[l] = nums[r];
            }

            while (l < r && nums[l] >= temp)
                l++;

            if (l < r) {
                nums[r] = nums[l];
            }
        }
        nums[l] = temp;
        return l;
    }

    public static int search(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        System.out.println("p:" + p);
        System.out.println("nums:" + Arrays.toString(nums));
        if (p == k - 1)
            return nums[p];
        if (p < k - 1) {
            return search(nums, p + 1, r, k);
        } else {
            return search(nums, l, p - 1, k);
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1, 5, 6, 7};
        System.out.println(findKthLargest(arr, 3));
    }
}
