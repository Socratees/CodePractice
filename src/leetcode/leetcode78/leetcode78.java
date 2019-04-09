package leetcode.leetcode78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<Integer>();
        result.add(empty);

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            result.add(list);
        }
//        System.out.println(result);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).size() == i) {
                    //遍历nums
                    for (int k = 0; k < nums.length; k++) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.addAll(result.get(j));
                        if (!tmp.contains(nums[k])) {
                            tmp.add(nums[k]);
                        }
//                        System.out.println(tmp);
//                        System.out.println(result);
//                        System.out.println(tmp);
//                        System.out.println(isContained(result, tmp));
                        if (!isContained(result, tmp)) {
                            result.add(tmp);
                        }

                    }
                }
            }
        }
        return result;
    }

    public static boolean isContained(List<List<Integer>> list1, List<Integer> list2) {
        boolean flag = false;
        for (int i = 0; i < list1.size(); i++) {
            flag = false;
            List<Integer> newList = list1.get(i);
            if (newList.size() != list2.size()) {
                flag = false;
                continue;
            } else {
                flag = true;
            }

            for (int j = 0; j < newList.size(); j++) {
                if (!list2.contains(list1.get(i).get(j))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(subsets(nums));
        System.out.println(isContained(subsets(nums), list));
    }
}
