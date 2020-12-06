package leetcode.leetcode118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 1){
            List<Integer> list = Arrays.asList(1);
            result.add(list);
        }
        else if(numRows == 2){
            List<Integer> list1 = Arrays.asList(1);
            List<Integer> list2 = Arrays.asList(1,1);
            result.add(list1);
            result.add(list2);
        }
        else if(numRows > 2){
            List<Integer> list1 = Arrays.asList(1);
            List<Integer> list2 = Arrays.asList(1,1);
            result.add(list1);
            result.add(list2);
            for(int i = 2; i < numRows; i++){
                List<Integer> line = new ArrayList<>();
                line.add(1);
                for(int j = 0; j < i - 1; j++){
                    line.add(result.get(i-1).get(j) + result.get(i-1).get(j+1));
                }
                line.add(1);
                result.add(line);
            }
        }
//        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        leetcode118 l = new leetcode118();
        l.generate(7);
    }
}
