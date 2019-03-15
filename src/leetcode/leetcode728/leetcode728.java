package leetcode.leetcode728;

import java.util.ArrayList;
import java.util.List;

public class leetcode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = left; i <= right; i++) {
            String str = String.valueOf(i);
            flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (str.substring(j, j + 1).equals("0") || i % Integer.parseInt(str.substring(j, j + 1)) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(i);
        }
        return list;
    }
}
