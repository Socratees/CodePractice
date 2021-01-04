package others.oj_njuse.problem117;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int length = input[0];
            int[] nums = Arrays.copyOfRange(input,1,input.length);

            for (int i = 0; i < length; i++) {
                int index = i;
                for (int j = i + 1; j < length; j++) {
                    if (nums[index] > nums[j]) {
                        index = j;
                    }
                }
                if (index != i) {
                    int tmp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = tmp;
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
}
