package others.oj_njuse.problem113;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int length = scanner.nextInt();
                int target = scanner.nextInt();
                int[] nums = new int[length];
                for (int i = 0; i < length; i++) {
                    nums[i] = scanner.nextInt();
                }
                Arrays.sort(nums);
                List<List<Integer>> result = new ArrayList<>();
                int pa = 0;
                int pb = 1;
                int pc = 2;
                int pd = nums.length - 1;
                if (nums.length < 4) {
                    return;
                }
                for (; pa < nums.length; pa++) {
                    for (pb = pa + 1; pb < nums.length; pb++) {
                        pc = pb + 1;
                        pd = nums.length - 1;
                        while (pc < pd) {
                            int sum = nums[pa] + nums[pb] + nums[pc] + nums[pd];
                            if (sum == target) {
                                result.add(Arrays.asList(nums[pa], nums[pb], nums[pc], nums[pd]));
                                pc++;
                                pd--;
                            } else if (sum < target) {
                                pc++;
                                while (nums[pc - 1] == nums[pc] && pc < pd) {
                                    pc++;
                                }
                            } else {
                                pd--;
                                while (nums[pd] == nums[pd + 1] && pc < pd) {
                                    pd--;
                                }
                            }

                        }
                    }
                }

                for(int i=0;i<result.size();i++){
                    for(int j=0;j<result.get(i).size();j++){
                        System.out.print(result.get(i).get(j)+" ");
                        if(j==result.get(i).size() - 1){
                            System.out.print("$");
                        }
                    }
                    if(i==result.size() - 1){
                        System.out.println();
                    }
                }

            }
        }
    }

}
