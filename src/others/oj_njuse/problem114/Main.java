package others.oj_njuse.problem114;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int length = scanner.nextInt();
                scanner.nextLine();
                String line = "";
                int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(nums);
                for(int i=0;i<nums.length;i++){
                    if(i==nums.length - 1){
                        System.out.println(nums[i]);
                    }else{
                        System.out.print(nums[i]+" ");
                    }
                }
            }
        }
    }
}
