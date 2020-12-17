package others.jzoffer.problem9;

public class Solution {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
//        queue.output();
        queue.deleteHead();
//        queue.output();
        queue.deleteHead();
    }
}
