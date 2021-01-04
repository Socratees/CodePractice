package leetcode.leetcode239;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k >= nums.length) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        //双端队列，存储的是元素下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //前k个值的降序队列，作为初始化状态
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[0] = nums[deque.getFirst()];
        //第k+1个值开始，需要判断队首与当前元素下标之差是否达到k，达到k则队首出队
        for (int i = k; i < result.length + k - 1; i++) {
            while (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            //比当前元素小的全都从队尾出队
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //我们保证了每一步的队首都是当前窗口的最大值的下标，输出到result中
            result[i - k + 1] = nums[deque.getFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
