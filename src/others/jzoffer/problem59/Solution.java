package others.jzoffer.problem59;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        result[index++] = nums[deque.getFirst()];

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            result[index++] = nums[deque.getFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(new int[]{2,3,4,2,6,2,5,1}, 3);
        System.out.println(Arrays.toString(res));
    }
}
