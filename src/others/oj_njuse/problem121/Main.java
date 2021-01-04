package others.oj_njuse.problem121;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = 0;
        while (scanner.hasNext()) {
            length = scanner.nextInt();
            int[] arr = new int[length];
            for(int i=0;i<length;i++){
                arr[i] = scanner.nextInt();
            }
            System.out.println(countPair(arr));
        }
    }

    public static int countPair(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int length = arr.length;
        int mid = length / 2;
        int count = 0;
        for (int i = 0; i < mid; i++) {
            for (int j = mid; j < length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        int[] leftArr = new int[mid];
        int[] rightArr = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = 0; i < length - mid; i++) {
            rightArr[i] = arr[i + mid];
        }
        return count + countPair(leftArr) + countPair(rightArr);
    }
}
