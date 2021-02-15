package others.jzoffer.problem57;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        List<int[]> list = new ArrayList<>();
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum > target) {
                left++;
            } else if (sum < target) {
                right++;
            } else {
                int[] tmp = new int[right - left + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = left + i;
                }
                list.add(tmp);
                right++;
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
