package others.oj_njuse.problem110;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = 0;
        int people = 0;
        while (scanner.hasNext()) {
            length = scanner.nextInt();
            int[] books = new int[length];
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                books[i] = scanner.nextInt();
                max = Math.max(max, books[i]);
                sum += books[i];
            }
            people = scanner.nextInt();
            int[] binaryArr = new int[sum - max + 1];
            for (int i = 0; i < sum - max + 1; i++) {
                binaryArr[i] = max + i;
            }
            int left = 0;
            int right = binaryArr.length - 1;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (countContainers(books, binaryArr[mid]) <= people) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(binaryArr[left]);

        }
    }

    public static int countContainers(int[] books, int size) {
        int count = 1;
        int currentSize = 0;
        for (int book : books) {
            if (currentSize + book > size) {
                count++;
                currentSize = book;
            } else {
                currentSize += book;
            }
        }

        return count;
    }
}
