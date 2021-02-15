package others.jzoffer.problem60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //    public double[] dicesProbability(int n) {
//        int[] times = new int[6 * n - n + 1];
//        backtrack(times, new ArrayList<>(), n);
//        double[] result = new double[times.length];
//        int sum = 0;
//        for (int num : times) {
//            sum += num;
//        }
//        for (int i = 0; i < result.length; i++) {
//            result[i] = (double) times[i] / (double) sum;
//        }
//        return result;
//    }
//
//    public void backtrack(int[] times, List<Integer> list, int n) {
//        if (list.size() == n) {
//            int sum = 0;
//            for (int num : list) {
//                sum += num;
//            }
//            times[sum - n]++;
//            return;
//        }
//        for (int i = 1; i <= 6; i++) {
//            list.add(i);
//            backtrack(times, list, n);
//            list.remove(list.size() - 1);
//        }
//    }
    public double[] dicesProbability(int n) {
        int[] times = new int[6 * n + 1];
        double[] result = new double[6 * n - n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 6 * i; j >= i; j--) {
                if (i == 1) {
                    times[j]++;
                } else {
                    int sum = 0;
                    for (int k = 6; k >= 1; k--) {
                        if (j - k >= 1) {
                            sum += times[j - k];
                        }
                    }
                    times[j] = sum;
                }
            }
            if (i != 1) {
                for (int j = 0; j < i; j++) {
                    times[j] = 0;
                }
            }
        }
//        System.out.println(Arrays.toString(times));
        int add = 0;
        for (int i = n; i <= 6 * n; i++) {
            add += times[i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = (double) times[i + n] / (double) add;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] res = solution.dicesProbability(4);
        System.out.println(Arrays.toString(res));
    }
}
