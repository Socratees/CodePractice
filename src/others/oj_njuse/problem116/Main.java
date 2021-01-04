package others.oj_njuse.problem116;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = "";
        for (int k = 0; k < n; k++) {
            line = scanner.nextLine();
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            nums = Arrays.copyOfRange(nums, 1, nums.length);
            for (int i = 1; i < nums.length; i++) {
                int index = i;
                int tmp = 0;
                while (index >= 1 && nums[index] < nums[index - 1]) {
                    tmp = nums[index];
                    nums[index] = nums[index - 1];
                    nums[index - 1] = tmp;
                    index--;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.println(nums[i]);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}
