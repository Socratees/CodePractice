package others.jzoffer.problem53;

public class Solution2 {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                if(mid==0||nums[mid-1]==mid-1){
                    return mid;
                }
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.missingNumber(new int[]{0, 1}));
    }
}
