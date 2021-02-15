package others.jzoffer.problem45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //本质上是一个排序问题，若ab<ba，则a应在b前面，且这个性质满足自反，对称，传递性
    //    public String minNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int index = i;
//            for (int j = i; j < nums.length; j++) {
//                if (compareInt(nums[index], nums[j]) > 0) {
//                    index = j;
//                }
//            }
//            if (index != i) {
//                int tmp = nums[index];
//                nums[index] = nums[i];
//                nums[i] = tmp;
//            }
//        }
//        StringBuilder builder = new StringBuilder();
//        for (int n : nums) {
//            builder.append(n);
//        }
//        return new String(builder);
//
//
//    }
//
//    public int compareInt(int a, int b) {
//        String strA = String.valueOf(a) + b;
//        String strB = String.valueOf(b) + a;
//        return strA.compareTo(strB);
//    }
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int n : nums) {
            list.add(String.valueOf(n));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }
}
