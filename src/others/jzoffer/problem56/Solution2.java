package others.jzoffer.problem56;

public class Solution2 {
    public int singleNumber(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int digitCount = 0;
        while (max != 0) {
            max = max >> 1;
            digitCount++;
        }

        int result = 0;
        for (int i = 1; i <= digitCount; i++) {
            //第i低位的1
            int andParam = 1<<(i-1);
            int digits = 0;
            for (int n : nums) {
                digits += (n & andParam) != 0 ? 1 : 0;
            }
            if (digits % 3 != 0) {
                result += (1 << i - 1);
            }
        }
        return result;
    }
//    public int singleNumber(int[] nums) {
//        int[] helper = new int[32];
//        int result = 0;
//        for (int i = 0; i < helper.length; i++) {
//            for (int n : nums) {
//                helper[i] += ((1 << i) & n) != 0 ? 1 : 0;
//            }
//            if (helper[i] % 3 != 0) {
//                result += (1 << i);
//            }
//        }
//
//        return result;
//
//    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.singleNumber(new int[]{3, 555, 3, 3, 1, 1, 1}));
    }
}
