package others.jzoffer.problem53;

public class Solution {
//    public int search(int[] nums, int target) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        return binarySearch(nums, 0, nums.length - 1, target);
//    }
//
//    public int binarySearch(int[] nums, int left, int right, int target) {
//        if (right < left) {
//            return 0;
//        }
//        if (right == left) {
//            return (nums[left] == target) ? 1 : 0;
//        }
//        int mid = (left + right) / 2;
//        if(nums[mid]<target){
//            return binarySearch(nums, mid + 1, right, target);
//        }
//        if(nums[mid]>target){
//            return binarySearch(nums, left, mid, target);
//        }
//        return binarySearch(nums, left, mid, target) + binarySearch(nums, mid + 1, right, target);
//    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length;
        int mid = 0;
        int start = 0, end = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        start = left - 1;
        left = 0;
        right = nums.length;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        end = right;
        return end - start + 1;
    }

}
