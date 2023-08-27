package leetcode2.p6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<List<String>> zList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zList.add(new ArrayList<>());
        }
        int rowNum = 0;
        //true表示向下，false表示向上
        boolean direction = true;
        for (int i = 0; i < s.length(); i++) {
            zList.get(rowNum).add(s.substring(i, i + 1));
            if (rowNum == numRows - 1 && direction) {
                direction = false;
            } else if (rowNum == 0 && !direction) {
                direction = true;
            }
            if (direction) {
                rowNum++;
            } else {
                rowNum--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zList.size(); i++) {
            for (int j = 0; j < zList.get(i).size(); j++) {
                sb.append(zList.get(i).get(j));
            }
        }
        return sb.toString();
    }
}
