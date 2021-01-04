package leetcode.leetcode155;

import java.util.Arrays;

public class MinStack {
    private int[] arr;
    private int[] minArr;
    private int top;
//    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        top = -1;
//        min = -1;
        arr = new int[100];
        minArr = new int[100];
    }

    public void push(int x) {
        if (top == arr.length - 1) {
            int[] tmp = Arrays.copyOf(arr, arr.length);
            int[] tmpMin = Arrays.copyOf(minArr, minArr.length);
            arr = new int[tmp.length * 2];
            minArr = new int[tmpMin.length * 2];
            System.arraycopy(tmp, 0, arr, 0, tmp.length);
            System.arraycopy(tmpMin, 0, minArr, 0, tmpMin.length);

        }
        top++;
        arr[top] = x;
        if (top == 0) {
//                min = 0;
            minArr[top] = x;
        } else {
//                min = (x < arr[min]) ? top : min;
            minArr[top] = Math.min(x, minArr[top - 1]);
        }
    }

    public void pop() {
        if (top < 0) {
            return;
        }
        top--;
    }

    public int top() {
        if(top<0){
            return -1;
        }
        return arr[top];
    }

    public int getMin() {
        if(top<0){
            return -1;
        }
        return minArr[top];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

