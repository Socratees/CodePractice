package others.jzoffer.problem51;

public class Solution {
    public int reversePairs(int[] nums) {
        return reverse(nums, 0, nums.length - 1);
    }

    //归并排序，需要O(n)的辅助数组
    public int reverse(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (left + right) / 2;
        int result = 0;
        int leftCount = reverse(nums, left, mid);
        int rightCount = reverse(nums, mid + 1, right);

        //辅助数组
        int[] arr = new int[right - left + 1];
        int index = arr.length - 1;
        int p1 = mid, p2 = right;
        while (p1 >= left && p2 >= mid + 1) {
            if (nums[p1] > nums[p2]) {
                arr[index--] = nums[p1];
                result += p2 - mid;
                p1--;
            } else {
                arr[index--] = nums[p2];
                p2--;
            }
        }
        while (p1>=left){
            arr[index--] = nums[p1];
            p1--;
        }
        while (p2>=mid+1){
            arr[index--] = nums[p2];
            p2--;
        }
        System.arraycopy(arr, 0, nums, left, arr.length);
        return result + leftCount + rightCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
