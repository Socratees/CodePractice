package others.oj_njuse.problem115;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //任意交换两个元素，求使数组有序的最小交换次数，等于数组长度减去循环节个数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNum = scanner.nextInt();
        for (int c = 0; c < caseNum; c++) {
            int length = scanner.nextInt();
            scanner.nextLine();
            String line = scanner.nextLine();
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] sorted = nums.clone();
            Arrays.sort(sorted);
//            System.out.println(Arrays.toString(sorted));
            int[] index = new int[sorted[sorted.length - 1] + 1];
            //建立元素到下标的映射关系
            for (int i = 0; i < sorted.length; i++) {
                index[sorted[i]] = i;
            }
//            System.out.println(Arrays.toString(index));

            //维护一个访问元素的数组
            boolean[] isVisited = new boolean[nums.length];
            int circle = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!isVisited[i]) {
                    //元素位置若正确，则自成一个循环节
                    if (nums[i] == sorted[i]) {
                        circle++;
                        isVisited[i] = true;
                    } else {
                        //元素位置不正确，则寻找对应位置的元素是否与当前位置构成循环节
                        int j = index[nums[i]];
                        isVisited[j] = true;
                        while (nums[j] != sorted[i]) {
                            j = index[nums[j]];
                            isVisited[j] = true;
                        }
                        circle++;
                    }
                }
            }

            System.out.println(nums.length - circle);
        }
    }
}
