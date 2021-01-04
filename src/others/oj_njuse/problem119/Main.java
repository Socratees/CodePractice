package others.oj_njuse.problem119;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    //非递归的快速排序，用栈来实现！
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int length = input[0];
            int[] nums = Arrays.copyOfRange(input, 1, input.length);
            int start = 0;
            int end = length - 1;
            Stack<Integer> stack = new Stack<>();
            if (start < end) {
                stack.push(end);
                stack.push(start);
                while (!stack.isEmpty()) {
                    int l = stack.pop();
                    int r = stack.pop();
                    int index = partition(nums, l, r);
                    if (l < index - 1) {
                        stack.push(index - 1);
                        stack.push(l);
                    }
                    if (index + 1 < r) {
                        stack.push(r);
                        stack.push(index+1);
                    }
                }
            }

            for (int k = 0; k < length; k++) {
                if (k != length - 1) {
                    System.out.print(nums[k] + " ");
                } else {
                    System.out.println(nums[k]);
                }
            }
        }
    }

    //取arr[left]做“基准”数
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
