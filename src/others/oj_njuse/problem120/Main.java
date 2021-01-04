package others.oj_njuse.problem120;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int length = input[0];
            int[] nums = Arrays.copyOfRange(input, 1, input.length);
            doSort(nums, 0, nums.length - 1);
            for (int k = 0; k < length; k++) {
                if (k != length - 1) {
                    System.out.print(nums[k] + " ");
                } else {
                    System.out.println(nums[k]);
                }
            }
        }
    }

    public static void doSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            doSort(arr, left, mid);
            doSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
