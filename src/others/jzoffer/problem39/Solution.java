package others.jzoffer.problem39;

public class Solution {
    //摩尔投票法,遍历下一个数时，与上一个相同则次数加一，否则减一，减为零则记录下一个数
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                result = n;
                count++;
            } else {
                if (result == n) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return result;
    }

}
