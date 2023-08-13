package leetcode2.p295;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> smaller;

    private PriorityQueue<Integer> larger;

    private int currentSize;

    public MedianFinder() {
        this.smaller = new PriorityQueue<>((a, b) -> b - a);
        this.larger = new PriorityQueue<>((a, b) -> a - b);
        this.currentSize = 0;
    }

    public void addNum(int num) {
        if (currentSize % 2 == 0) {
            larger.offer(num);
            smaller.offer(larger.poll());
        } else {
            smaller.offer(num);
            larger.offer(smaller.poll());
        }
        currentSize++;
    }

    public double findMedian() {
        if (currentSize == 0) {
            return 0;
        }
        if (currentSize == 1) {
            return smaller.peek();
        }
        if (currentSize % 2 == 0) {
            return (smaller.peek() + larger.peek()) / 2.0;
        } else {
            return smaller.peek();
        }
    }
}
