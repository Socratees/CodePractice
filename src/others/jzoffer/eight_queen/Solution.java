package others.jzoffer.eight_queen;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> eightQueen() {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>());
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> list) {
        if (list.size() == 8) {
            //检查是否有任意两个棋子在同一对角线上
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (j - i == Math.abs(list.get(i) - list.get(j))){
                        return;
                    }
                }
            }
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!list.contains(i)) {
                list.add(i);
                backtrack(result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result= solution.eightQueen();
        System.out.println(result);
        System.out.println(result.size());
    }
}
