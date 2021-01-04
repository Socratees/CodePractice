package others.oj_njuse.problem107;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int length = scanner.nextInt();
                int[] nums = new int[length];
                for (int i = 0; i < length; i++) {
                    nums[i] = scanner.nextInt();
                }
                int layer = 0;
                int sum = 0;
                while (sum < length) {
                    sum += (int) Math.pow(2, layer);
                    layer++;
                }
                int left = 0;
                int right = 0;
                for (int i = 0; i < layer; i++) {
                    left = (int) Math.pow(2, i) - 1;
                    if (i != layer - 1) {
                        right = left + (int) Math.pow(2, i) - 1;
                    } else {
                        right = length - 1;
                    }
                    mySort(nums, left, right);
                    for (int j = left; j <= right; j++) {
                        if (j == right) {
                            System.out.println(nums[j]);
                        } else {
                            System.out.print(nums[j] + " ");
                        }
                    }
                }


            }


        }
    }

    public static void mySort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        for (int i = left; i <= right; i++) {
            int index = i;
            for (int j = i; j <= right; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
