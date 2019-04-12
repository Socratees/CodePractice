package leetcode.leetcode77;

import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> com = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        recursive(com, c, n, k);
        return com;
    }

    public void recursive(List<List<Integer>> list, List<Integer> result, int n, int k) {

        if(k == 0){
            list.add(result);
            return;
        }

        if(n < k){
            return;
        }
        for (int i = n; i >= 1; i--) {
            List<Integer> l = new ArrayList<>();
            l.addAll(result);
            l.add(i);
            recursive(list, l, i - 1, k - 1);
        }
    }

    public static void main(String[] args) {
        leetcode77 leetcode77 = new leetcode77();
        System.out.println(leetcode77.combine(4,2));
    }
}
