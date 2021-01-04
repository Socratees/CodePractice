package others.oj_njuse.problem122;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        scanner.nextLine();
        String line = "";
        for (int n = 0; n< caseNum; n++) {
            line = scanner.nextLine();
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            line = scanner.nextLine();
            int[] steps = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int stepSize : steps) {
                for (int i = 0; i < stepSize; i++) {
                    for (int j = i; j < nums.length; j += stepSize) {
                        int index = j;
                        for (int m = j; m < nums.length; m += stepSize) {
                            if (nums[index] > nums[m]) {
                                index = m;
                            }
                        }
                        if (index != j) {
                            int tmp = nums[index];
                            nums[index] = nums[j];
                            nums[j] = tmp;
                        }
                    }

                }
            }

            for (int k = 0; k < nums.length; k++) {
                if (k != nums.length - 1) {
                    System.out.print(nums[k] + " ");
                } else {
                    System.out.println(nums[k]);
                }
            }

        }
    }
}
