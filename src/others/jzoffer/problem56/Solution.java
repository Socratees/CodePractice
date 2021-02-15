package others.jzoffer.problem56;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int xorResult = 0;
        for (int n : nums) {
            xorResult ^= n;
        }
        //找出不为0的最高位
//        int digitCount = 0;
//        while (xorResult != 0) {
//            xorResult = xorResult >> 1;
//            digitCount++;
//        }
//        int andParam = (int) Math.pow(2, digitCount - 1);
        //x&(-x)可以找出x最低位的1
        int andParam = xorResult & (-xorResult);
        int res1 = 0, res2 = 0;
        for (int n : nums) {
            if ((n & andParam) != 0) {
                res1 ^= n;
            } else {
                res2 ^= n;
            }
        }

        return new int[]{res1, res2};
    }


}
