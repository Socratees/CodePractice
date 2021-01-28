package others.jzoffer.problem41;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    int count;
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        count = 0;
        maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        minQueue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
    }

    public void addNum(int num) {
        count++;
        if (count % 2 == 1) {
            if (count == 1 || (!minQueue.isEmpty() && num <= minQueue.peek())) {
                maxQueue.add(num);
            }else{
                minQueue.add(num);
                maxQueue.add(minQueue.poll());
            }
        } else {
            if (!maxQueue.isEmpty() && num >= maxQueue.peek()) {
                minQueue.add(num);
            } else {
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (count == 0) {
            return 0;
        }
        if (count%2 == 1 && !maxQueue.isEmpty()) {
            return (double) maxQueue.peek();
        } else {
            return (double) (maxQueue.peek() + minQueue.peek()) * 0.5;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
