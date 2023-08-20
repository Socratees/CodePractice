package leetcode2.p56;

import java.util.LinkedList;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                int[] left = intervals[i];
                int[] right = intervals[j];
                if (left[0] > right[0]) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }

        LinkedList<int[]> list = new LinkedList<>();
        list.offerLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[][] mergeTwo = mergeTwo(list.pollLast(), intervals[i]);
            for (int j = 0; j < mergeTwo.length; j++) {
                list.offerLast(mergeTwo[j]);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int[][] mergeTwo(int[] leftArr, int[] rightArr) {
        if (leftArr[1] < rightArr[0]) {
            return new int[][]{leftArr, rightArr};
        } else if (leftArr[1] >= rightArr[0] && leftArr[1] <= rightArr[1]) {
            return new int[][]{{leftArr[0], rightArr[1]}};
        } else {
            return new int[][]{leftArr};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        solution.merge(arr);
    }
}
