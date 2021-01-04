package leetcode.leetcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size() - 1) >= intervals[i][1]) {
                continue;
            } else if (list.get(list.size() - 1) < intervals[i][0]) {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            } else {
                list.remove(list.size() - 1);
                list.add(intervals[i][1]);
            }

        }
        int[][] result = new int[list.size() / 2][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = list.get(i * 2);
            result[i][1] = list.get(i * 2 + 1);
        }

        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        intervals = solution.merge(intervals);
        for (int[] arr : intervals) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
