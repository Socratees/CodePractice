package others.jzoffer.problem9;

import java.util.Stack;

public class MyQueue {
    private Stack<Object> stack1 = new Stack<>();
    private Stack<Object> stack2 = new Stack<>();

    public void appendTail(Object element) {
        stack1.push(element);
    }

    public void deleteHead() {
        if (!stack2.isEmpty()) {
            stack2.pop();
        } else if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack2.pop();
        } else {
            System.out.println("The queue is empty");
        }
    }

    public void output() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().toString() + " ");
        }
    }
}
