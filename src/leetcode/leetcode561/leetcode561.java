package leetcode.leetcode561;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class leetcode561 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        int temp = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length; i++){
            if(i%2 == 0){
                sum+=nums[i];
            }
        }

        return sum;
    }
}
