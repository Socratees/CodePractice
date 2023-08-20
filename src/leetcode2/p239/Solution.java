package leetcode2.p239;

import java.util.LinkedList;

public class Solution {

    /**
     * 双向单调队列，每次遍历，判断与队尾（存下标）的大小，队尾小则一直删除队尾，然后将下标入队；然后，判断队首是否在窗口范围，若不在，一直删除队首
     * 维护一个单调递减的双向队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        res[0] = nums[queue.peek()];
        int resIndex = 1;
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.removeFirst();
            }
            res[resIndex] = nums[queue.peek()];
            resIndex++;
        }
        return res;
    }
}
