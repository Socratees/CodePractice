package leetcode.leetcode53;

public class leetcode53 {
    public int maxSubArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            System.out.println(getMax(i,nums));
        }
        return getMax(nums.length - 1, nums);
    }

    public int getMax(int index, int[] nums) {
        if (index == 0)
            return nums[0];
        return Math.max(getMax(index - 1, nums) + nums[index], nums[index]);
    }

    public static void main(String[] args) {
        leetcode53 leetcode = new leetcode53();
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        leetcode.maxSubArray(array);
    }
}
