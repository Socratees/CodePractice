package leetcode.leetcode406;

import java.util.Arrays;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length <= 1) {
            return people;
        }
        for (int i = 0; i < people.length; i++) {
            int index = i;
            for (int j = i; j < people.length; j++) {
                if (comparePeople(people[index], people[j]) < 0) {
                    index = j;
                }
            }
            if (index != i) {
                int[] tmp = people[i];
                people[i] = people[index];
                people[index] = tmp;
            }
        }
//        for (int[] arr : people) {
//            System.out.print(Arrays.toString(arr) + " ");
//        }
//        System.out.println();
        int[][] result = new int[people.length][people[0].length];
        for (int i = 0; i < people.length; i++) {
            int pos = people[i][1];
            for (int j = i; j > pos; j--) {
                result[j] = result[j - 1];
            }
            result[pos] = people[i];
        }

        return result;

    }

    public int comparePeople(int[] arr1, int[] arr2) {
        if (arr1[0] != arr2[0]) {
            return Integer.compare(arr1[0], arr2[0]);
        }
        return -Integer.compare(arr1[1], arr2[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] arr : res) {
            System.out.print(Arrays.toString(arr) + " ");
        }
    }
}
