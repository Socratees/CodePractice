package leetcode2.p57;

import java.util.LinkedList;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        LinkedList<int[]> list = new LinkedList<>();
        boolean addNewInternal = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!addNewInternal && compare(intervals[i], newInterval)) {
                addNewInternal = true;
                if (!list.isEmpty() && canMerge(list.getLast(), newInterval)) {
                    list.add(merge(list.pollLast(), newInterval));
                } else {
                    list.add(newInterval);
                }
            }
            if (!list.isEmpty() && canMerge(list.getLast(), intervals[i])) {
                list.add(merge(list.pollLast(), intervals[i]));
            } else {
                list.add(intervals[i]);
            }

        }
        if (!addNewInternal) {
            if (!list.isEmpty() && canMerge(list.getLast(), newInterval)) {
                list.add(merge(list.pollLast(), newInterval));
            } else {
                list.add(newInterval);
            }
        }

        int[][] tmp = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }
        return tmp;

    }

    public boolean canMerge(int[] left, int[] right) {
        return right[0] >= left[0] && right[0] <= left[1];
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[2];
        res[0] = left[0];
        res[1] = Math.max(left[1], right[1]);
        return res;
    }

    public boolean compare(int[] a, int[] b) {
        return a[0] > b[0] || (a[0] == b[0] && a[1] >= b[1]);
    }
}
